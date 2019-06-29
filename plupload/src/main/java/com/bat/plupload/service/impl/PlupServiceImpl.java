package com.bat.plupload.service.impl;

import com.bat.plupload.config.PluploadConfig;
import com.bat.plupload.request.PlupLoadRequest;
import com.bat.plupload.service.PlupService;
import com.bat.plupload.util.RedisUtils;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 服务接口实现
 *
 * @author ZhengYu
 * @version 1.0 2019/6/16 11:28
 **/
@Service
public class PlupServiceImpl implements PlupService {

    private Logger logger = LoggerFactory.getLogger(PlupServiceImpl.class);

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private PluploadConfig pluploadConfig;

    /**
     * 上传文件
     *
     * @param file            文件
     * @param plupLoadRequest 文件分包信息
     * @author ZhengYu
     */
    @Override
    public void uploadFile(MultipartFile file, PlupLoadRequest plupLoadRequest) {
        byte[] fileBytes = null;
        try {
            fileBytes = file.getBytes();
        } catch (IOException e) {
            logger.info("二进制文件读取失败!!!");
            e.printStackTrace();
        }
        String redisKeyPrefix = plupLoadRequest.getRedisKey();
        logger.info("redis 写入 ===> redisKey={} ,fileBytes{}", redisKeyPrefix + plupLoadRequest.getChunk(), fileBytes == null ? "无数据" : "有数据");
        redisUtils.setObjectToRedis(redisKeyPrefix + plupLoadRequest.getChunk(), fileBytes, 60);
        if (plupLoadRequest.isFirstPackage()) {
            // 开启线程执行读取操作
            ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-upload-task-%d").build();
            ExecutorService commonExecutorService = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024), threadFactory, new ThreadPoolExecutor.AbortPolicy());
            commonExecutorService.execute(() -> {
                logger.info("文件上传开始!");
                AtomicInteger tryCount = new AtomicInteger(1);
                AtomicInteger uploadChuck = new AtomicInteger(0);
                do {
                    logger.info("正在处理第{}个分包, redisKey={}", uploadChuck.get(), redisKeyPrefix + uploadChuck.get());
                    Object objectFromRedis = redisUtils.getObjectFromRedis(redisKeyPrefix + uploadChuck.get());
                    // 重试
                    while (objectFromRedis == null && tryCount.getAndIncrement() <= pluploadConfig.getMaxTryCount()) {
                        try {
                            // 设置每次重试的等待间隔
                            Thread.sleep(pluploadConfig.getTryInterval());
                            objectFromRedis = redisUtils.getObjectFromRedis(redisKeyPrefix + uploadChuck.get());
                            logger.info("第{}次重试...重试结果为：{}获取到数据包!", tryCount.get(), objectFromRedis == null ? "未能" : "成功");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (objectFromRedis == null) {
                        logger.info("重试次数过多，任务结束!!!");
                        // TODO 发送失败通知
                        // TODO 停止线程任务
                        // TODO 清理动作
                        break;
                    } else {
                        // 存储文件
                        try {
                            File uploadFile = createUploadFile(plupLoadRequest.getFileUploadDir(pluploadConfig), plupLoadRequest.getName());
                            if (!uploadFile.exists()) {
                                logger.info("临时文件创建失败，任务结束!!!");
                                break;
                            }
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(uploadFile, true));
                            try {
                                bufferedOutputStream.write((byte[]) objectFromRedis);
                                bufferedOutputStream.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } finally {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (FileNotFoundException e) {
                            logger.info("获取文件上传路径失败!!!");
                            e.printStackTrace();
                            break;
                        }
                        // 每次成功重置重试次数
                        tryCount.set(1);
                        uploadChuck.incrementAndGet();
                    }
                } while (uploadChuck.get() < plupLoadRequest.getChunks());
                // TODO 发送上传成功通知
                logger.info("文件上传成功!");
            });
        }
    }

    /**
     * 创建本地磁盘文件
     *
     * @param fileUploadPath 文件路径
     * @param fileUploadName 文件名称
     * @return java.io.File
     * @author ZhengYu
     */
    private File createUploadFile(String fileUploadPath, String fileUploadName) {
        logger.info("创建存储文件：存储路径为：{} ,文件名称为：{}", fileUploadPath, fileUploadName);
        File uploadFile = new File(fileUploadPath, fileUploadName);
        if (uploadFile.exists()) {
            return uploadFile;
        }
        File filePath = new File(fileUploadPath);
        boolean pathFlag = true;
        if (!filePath.exists()) {
            pathFlag = filePath.mkdirs();
        }
        if (!pathFlag) {
            logger.info("创建文件存储路径失败...上传任务终止，文件存储路径为：{}", fileUploadPath);
        }
        uploadFile = new File(fileUploadPath, fileUploadName);
        boolean fileFlag = true;
        if (!uploadFile.exists()) {
            try {
                fileFlag = uploadFile.createNewFile();
            } catch (IOException e) {
                logger.info("创建文件失败...上传任务终止，文件全路径为：{} -> {}", fileUploadPath, fileUploadName);
                e.printStackTrace();
            }
        }
        if (!fileFlag) {
            logger.info("创建文件失败...上传任务终止，文件全路径为：{} -> {}", fileUploadPath, fileUploadName);
        }
        return uploadFile;
    }
}
