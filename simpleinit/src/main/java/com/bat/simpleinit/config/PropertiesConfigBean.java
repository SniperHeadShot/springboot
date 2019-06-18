package com.bat.simpleinit.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 读取自定义 xxx.properties 配置文件内容
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:09
 **/
@Configuration
@PropertySource(value = "classpath:additionalConfig.properties")
@ConfigurationProperties(prefix = "config")
@Data
public class PropertiesConfigBean {

    private String name;

    private Integer age;
}
