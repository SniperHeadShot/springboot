package com.bat.simpleinit.controller;

import com.bat.simpleinit.config.PropertiesConfigBean;
import com.bat.simpleinit.config.ValueConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 读取配置文件内容 测试类
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:09
 **/
@RestController
public class ConfigureDemonstrateController {

    @Autowired
    private Environment environment;
    @Autowired
    private ValueConfigBean valueConfigBean;
    @Autowired
    private PropertiesConfigBean propertiesConfigBean;

    @Value("${init.name}")
    private String userName;

    /**
     * 读取 *.yml 文件内的配置[方式1]
     *
     * @return java.lang.String
     * @author ZhengYu
     * @date 2019/6/4
     */
    @GetMapping("/yml/config/method1")
    public String getApplicationConfigMethod1() {
        return "读取 *.yml 文件内的配置[方式1] ... " + environment.getProperty("init.name");
    }

    /**
     * 读取 *.yml 文件内的配置[方式2]
     *
     * @return java.lang.String
     * @author ZhengYu
     * @date 2019/6/4
     */
    @GetMapping("/yml/config/method2")
    public String getApplicationConfigMethod2() {
        return "读取 *.yml 文件内的配置[方式2] ... " + userName;
    }

    /**
     * 读取 *.yml 文件内的配置[方式3]
     *
     * @return java.lang.String
     * @author ZhengYu
     * @date 2019/6/4
     */
    @GetMapping("/yml/config/method3")
    public String getApplicationConfigMethod3() {
        return "读取 *.yml 文件内的配置[方式3] ... " + valueConfigBean.getName() + valueConfigBean.getConfig().getAge();
    }

    /**
     * 读取 *.properties 文件内的配置
     *
     * @return java.lang.String
     * @author ZhengYu
     * @date 2019/6/4
     */
    @GetMapping("/properties/config")
    public String additionalProperties() {
        return "读取 *.properties 文件内的配置 ... " + propertiesConfigBean.getName();
    }
}
