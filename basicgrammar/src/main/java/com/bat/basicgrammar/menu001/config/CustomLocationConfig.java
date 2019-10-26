package com.bat.basicgrammar.menu001.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 从自定义路径下的配置文件读取配置[经过测试只能读取.properties文件格式的配置]
 *
 * @author ZhengYu
 * @version 1.0 2019/10/26 15:03
 **/
@Data
@Component
@PropertySource(value = "file:${custom.configLocation}/customConfig.properties")
public class CustomLocationConfig {

    @Value("${custom.fileKey}")
    private String fileKey;
}
