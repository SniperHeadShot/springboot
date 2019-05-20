package com.bat.controller;

import com.bat.config.PropertiesConfigBean;
import com.bat.config.ValueConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DemonstrateController
 * @Description 读取配置文件内容
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/5/17 17:16
 **/
@RestController
public class DemonstrateController {

    @Autowired
    private ValueConfigBean valueConfigBean;

    @Autowired
    private PropertiesConfigBean propertiesConfigBean;

    @Value("${init.name}")
    private String userName;

    /**
     * @Param []
     * @Return java.lang.String
     * @Author ZhengYu
     * @Description: 测试将*.yml内的属性读取到实体类
     * @Date 2019/5/17
     */
    @GetMapping("/value")
    public String demonstrateSpringboot() {
        return "Hello " + userName + "! " + valueConfigBean.toString();
    }

    /**
     * @Param []
     * @Return java.lang.String
     * @Author ZhengYu
     * @Description: 测试将*.properties内的属性读取到实体类
     * @Date 2019/5/17
     */
    @GetMapping("/prop")
    public String additionalProperties() {
        return "Hello " + propertiesConfigBean.getName() + "! " + valueConfigBean.toString();
    }
}
