package com.bat.plupload.service.impl;

import com.bat.plupload.request.PlupLoadRequest;
import com.bat.plupload.service.PlupService;
import com.bat.plupload.util.RedisUtils;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.concurrent.*;
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

    /**
     * 上传文件
     *
     * @param file            文件
     * @param plupLoadRequest 文件分包信息
     * @author ZhengYu
     */
    @Override
    public void uploadFile(MultipartFile file, PlupLoadRequest plupLoadRequest) {
        try {
            byte[] fileBytes = file.getBytes();
            //String redisKey = plupLoadRequest.getRedisKey() + plupLoadRequest.getChunk();
            logger.info("redis 写入 ===> redisKey={},fileBytes={}", plupLoadRequest.getRedisKey() + plupLoadRequest.getChunk(), fileBytes);
            redisUtils.setObjectToRedis(plupLoadRequest.getRedisKey() + plupLoadRequest.getChunk(), fileBytes, 60);
            if (plupLoadRequest.isFirstPackage()) {
                // 开启线程执行读取操作
                ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-upload-task-%d").build();
                ExecutorService commonExecutorService = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024), threadFactory, new ThreadPoolExecutor.AbortPolicy());
                commonExecutorService.execute(() -> {
                    AtomicInteger tryCount = new AtomicInteger(1);
                    AtomicInteger uploadChuck = new AtomicInteger(0);
                    do {
                        logger.info("正在处理第{}个分包, redisKey={}", uploadChuck.get(), plupLoadRequest.getRedisKey() + uploadChuck.get());
                        Object objectFromRedis = redisUtils.getObjectFromRedis(plupLoadRequest.getRedisKey() + uploadChuck.get());
                        // 重试
                        while (objectFromRedis == null && tryCount.getAndIncrement() < 6) {
                            try {
                                Thread.sleep(5000);
                                objectFromRedis = redisUtils.getObjectFromRedis(plupLoadRequest.getRedisKey() + uploadChuck.get());
                                logger.info("第{}次重试中...", tryCount.get());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (objectFromRedis == null) {
                            logger.info("重试次数超时，任务结束!!!");
                            // TODO 发送失败通知
                            // TODO 停止线程任务
                            // TODO 清理动作
                        } else {
                            // 存储文件
                            try {
                                File uploadFile = new File(plupLoadRequest.getFileUploadDir(), plupLoadRequest.getName());
                                if (!uploadFile.exists()) {
                                    createUploadFile(plupLoadRequest.getFileUploadDir(), plupLoadRequest.getName());
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
                            }
                            tryCount.set(1);
                            uploadChuck.intValue();
                        }
                    } while (uploadChuck.get() < plupLoadRequest.getChunks());
                    // TODO 发送上传成功通知
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建本地磁盘文件
     *
     * @param fileUploadPath 文件路径
     * @param fileUploadName 文件名称
     * @author ZhengYu
     */
    private void createUploadFile(String fileUploadPath, String fileUploadName) {
        File filePath = new File(fileUploadPath);
        boolean pathFlag = true;
        if (!filePath.exists()) {
            pathFlag = filePath.mkdirs();
        }
        if (!pathFlag) {
            logger.info("创建文件存储路径失败...上传任务终止，文件存储路径为：{}", fileUploadPath);
        }
        File file = new File(fileUploadPath, fileUploadName);
        boolean fileFlag = true;
        if (!file.exists()) {
            try {
                fileFlag = file.createNewFile();
            } catch (IOException e) {
                logger.info("创建文件失败...上传任务终止，文件全路径为：{} -> {}", fileUploadPath, fileUploadName);
                e.printStackTrace();
            }
        }
        if (!fileFlag) {
            logger.info("创建文件失败...上传任务终止，文件全路径为：{} -> {}", fileUploadPath, fileUploadName);
        }
    }
}
