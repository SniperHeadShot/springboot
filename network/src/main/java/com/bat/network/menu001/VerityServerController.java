package com.bat.network.menu001;

import com.alibaba.fastjson.JSONObject;
import com.bat.network.menu001.dynamic.service.DynamicService;
import com.bat.network.menu001.normal.service.NormalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 验证服务端
 *
 * @author ZhengYu
 * @version 1.0 2019/10/26 16:04
 **/
@Slf4j
@RestController
public class VerityServerController {

    @Autowired
    private NormalService normalService;

    @Autowired
    private DynamicService dynamicService;

    @PostMapping("/verity")
    public void verity(@RequestHeader(value = "header1") String header1,
                       @RequestHeader(value = "header2") String header2,
                       @RequestParam(value = "param1") String param1,
                       @RequestParam(value = "param2") String param2,
                       @RequestBody BodyInfo bodyInfo) {
        log.info("header1:[{}], header2:[{}], param1:[{}], param2:[{}], body:[{}]", header1, header2, param1, param2, JSONObject.toJSONString(bodyInfo));
    }

    @GetMapping("/testNormal")
    public void testNormal() {
        normalService.sendHttpRequest();
    }

    @GetMapping("/testDynamic")
    public void testDynamic() {
        dynamicService.sendHttpRequest();
    }
}

