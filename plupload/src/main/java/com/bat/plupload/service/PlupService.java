package com.bat.plupload.service;

import com.bat.plupload.request.PlupLoadRequest;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName PlupService
 * @Description 服务接口
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/6/14 15:50
 **/
public interface PlupService {

    /**
     * 上传文件
     *
     * @param file
     * @param plupLoadRequest
     * @return void
     * @author ZhengYu
     * @date 2019/6/14
     */
    void uploadFile(MultipartFile file, PlupLoadRequest plupLoadRequest);
}
