package com.bat.plupload.service;

import com.bat.plupload.request.PlupLoadRequest;
import org.springframework.web.multipart.MultipartFile;

/**
 * 服务接口
 *
 * @author ZhengYu
 * @version 1.0 2019/6/16 11:28
 **/
public interface PlupService {

    /**
     * 上传文件
     *
     * @param file            文件
     * @param plupLoadRequest 文件分包信息
     * @author ZhengYu
     */
    void uploadFile(MultipartFile file, PlupLoadRequest plupLoadRequest);
}
