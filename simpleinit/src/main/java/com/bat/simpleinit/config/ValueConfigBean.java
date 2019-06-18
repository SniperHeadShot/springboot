package com.bat.simpleinit.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 将默认配置文件 application.properties/application.yml 中的配置赋值给实体类
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:09
 **/
@ConfigurationProperties(prefix = "init")
@Component
@Data
public class ValueConfigBean {

    private String name;

    private Config config;

    @Data
    public static class Config {

        private Integer age;

        private String sex;
    }
}
