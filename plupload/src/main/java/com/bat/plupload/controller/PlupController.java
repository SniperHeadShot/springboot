package com.bat.plupload.controller;

import com.bat.plupload.request.PlupLoadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

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
    public void largeFileUpload(@RequestBody MultipartFile file, PlupLoadRequest plupLoadRequest) {
        // TODO 校验参数
        String classPath = null;
        try {
            classPath = ResourceUtils.getURL("classpath:").getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        plupLoadRequest.setClasspath(classPath + plupLoadRequest.getProjectUuid() + System.getProperty("file.separator") + plupLoadRequest.getUserUuid());
    }
}
