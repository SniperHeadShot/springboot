package com.bat.druid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Druid 多数据源连接 且运行时动态切换
 *
 * @author ZhengYu
 * @version 1.0 2019/12/9 16:51
 **/
@SpringBootApplication
public class DruidApplication {
    public static void main(String[] args) {
        SpringApplication.run(DruidApplication.class, args);
    }
}
