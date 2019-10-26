package com.bat.basicgrammar.menu001.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 从yml或properties文件中取值
 *
 * @author ZhengYu
 * @version 1.0 2019/10/26 14:16
 **/
@Component
@PropertySource(value = "classpath:application.yml")
@ConfigurationProperties(prefix = "custom.menu001")
@Data
public class YmlConfig {

    private Info info;

    private App app;
}

@Data
class Info {

    private String username;

    private String password;
}

@Data
class App {

    private String key;

    private String value;
}