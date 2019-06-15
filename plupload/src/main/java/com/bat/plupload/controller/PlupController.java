package com.bat.plupload.controller;

import com.bat.plupload.request.PlupLoadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName PlupController
 * @Description 控制层
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/6/13 11:41
 **/
@RestController
public class PlupController {

    private final Logger logger = LoggerFactory.getLogger(PlupController.class);

    @CrossOrigin
    @PostMapping(value = "/uploadSmallFilePackage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String largeFileUpload(@RequestBody MultipartFile file, PlupLoadRequest plupLoadRequest) {
        String resultMessage;
        // TODO 校验参数

        // TODO 校验上传任务是否存在

        System.out.println();

        resultMessage = "上传任务开启成功";
        return resultMessage;
    }
}