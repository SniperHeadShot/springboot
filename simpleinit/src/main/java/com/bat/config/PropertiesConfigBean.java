package com.bat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName PropertiesConfigBean
 * @Description TODO
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/5/17 17:46
 **/
@Configuration
@PropertySource(value = "classpath:additionalConfig.properties")
@ConfigurationProperties(prefix = "config")
@Data
public class PropertiesConfigBean {

    private String name;

    private Integer age;
}
