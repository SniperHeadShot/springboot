package com.bat.plupload.service.impl;

import com.bat.plupload.request.PlupLoadRequest;
import com.bat.plupload.service.PlupService;
import com.bat.plupload.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName PlupServiceImpl
 * @Description 服务接口实现
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/6/14 15:51
 **/
public class PlupServiceImpl implements PlupService {

    private final String UPLOAD_LARGE_FILE_PREFIX = "device:upgrade:upload:";

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 上传文件
     *
     * @param file
     * @param plupLoadRequest
     * @return void
     * @author ZhengYu
     * @date 2019/6/14
     */
    @Override
    public void uploadFile(MultipartFile file, PlupLoadRequest plupLoadRequest) {
        String redisKey = UPLOAD_LARGE_FILE_PREFIX + plupLoadRequest.getProjectUuid() + ":" + plupLoadRequest.getUserUuid();
        if (plupLoadRequest.getChunk() == 0) {

        }
    }
}
