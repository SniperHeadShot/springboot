package com.bat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName User
 * @Description 测试_将配置文件中的数据赋值给实体类
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/5/17 17:25
 **/
@ConfigurationProperties(prefix = "init.config") //表明该类为配置属性类
@Component
@Data
public class ValueConfigBean {

    private String name;

    private Integer age;

    private String sex;
}
