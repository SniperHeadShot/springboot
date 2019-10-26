package com.bat.basicgrammar.menu001.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 从配置文件中读取静态变量
 *  1. 需要使用 @Component 注解
 *  2. set方法要是非静态的
 *
 * @author ZhengYu
 * @version 1.0 2019/10/26 15:29
 **/
@Component
public class StaticConfig {

    private static String username;

    public static String getUsername() {
        return username;
    }

    @Value("${custom.menu001.info.username}")
    public void setUsername(String username) {
        StaticConfig.username = username;
    }
}
