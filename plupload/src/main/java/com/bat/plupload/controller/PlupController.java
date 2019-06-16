package com.bat.plupload.controller;

import com.bat.plupload.request.PlupLoadRequest;
import com.bat.plupload.service.PlupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 控制层
 *
 * @author ZhengYu
 * @version 1.0 2019/6/16 11:28
 **/
@RestController
public class PlupController {

    private final Logger logger = LoggerFactory.getLogger(PlupController.class);

    @Autowired
    private PlupService plupService;

    /**
     * 发送分包请求
     *
     * @param file            文件
     * @param plupLoadRequest 分包参数
     * @author ZhengYu
     */
    @CrossOrigin
    @PostMapping(value = "/uploadSmallFilePackage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void largeFileUpload(@RequestBody MultipartFile file, PlupLoadRequest plupLoadRequest) {
        logger.info("接收到的分包上传请求参数: ===> {}", plupLoadRequest);
        plupService.uploadFile(file, plupLoadRequest);
    }
}