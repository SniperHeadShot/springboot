package com.bat.basicgrammar.menu001;

import com.alibaba.fastjson.JSONObject;
import com.bat.basicgrammar.menu001.config.CustomLocationConfig;
import com.bat.basicgrammar.menu001.config.StaticConfig;
import com.bat.basicgrammar.menu001.config.VmConfig;
import com.bat.basicgrammar.menu001.config.YmlConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示 @Value 的用法
 *
 * @author ZhengYu
 * @version 1.0 2019/10/23 14:22
 **/
@Slf4j
@RestController
@RequestMapping("/basicGrammar/menu001")
public class ValueCenterController {

    /**
     * 从yml或properties文件中取值
     */
    @Autowired
    private YmlConfig ymlConfig;

    /**
     * 从JVM启动参数中取值
     */
    @Autowired
    private VmConfig vmConfig;

    /**
     * 从自定义路径下的配置文件读取配置
     */
    @Autowired
    private CustomLocationConfig customLocationConfig;

    @GetMapping("/value")
    public void getValue() {
        log.info("从yml或properties文件中取值: [{}]", JSONObject.toJSONString(ymlConfig));

        log.info("从JVM启动参数中取值: [{}]", JSONObject.toJSONString(vmConfig));

        log.info("从自定义路径下的配置文件中取值: [{}]", JSONObject.toJSONString(customLocationConfig));

        log.info("从配置文件中读取配置为静态变量: [{}]", getStaticValue());
    }

    private static String getStaticValue() {
        return StaticConfig.getUsername();
    }
}
