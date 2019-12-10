package com.bat.druid.controller;

import com.alibaba.fastjson.JSONObject;
import com.bat.commoncode.entity.CustomStructure;
import com.bat.druid.config.DataSourceRoute;
import com.bat.druid.service.CustomStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * TODO
 *
 * @author ZhengYu
 * @version 1.0 2019/12/10 15:12
 **/
@RestController
public class TempController {

    private static final Random RANDOM = new Random();

    @Autowired
    private CustomStructureService customStructureService;

    @GetMapping("/db/test")
    public String test() {
        DataSourceRoute.setRouteKey("test2");

        CustomStructure customStructure = new CustomStructure("zy" + RANDOM.nextInt(100), RANDOM.nextInt(100));
        customStructureService.insertCustomStructure(null, customStructure);
        List<CustomStructure> customStructureList = customStructureService.getCustomStructureList(null);
        return JSONObject.toJSONString(customStructureList);
    }
}
