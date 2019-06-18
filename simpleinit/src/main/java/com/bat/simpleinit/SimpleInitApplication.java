package com.bat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @ClassName SimpleInitApplication
 * @Description Springboot基础知识演示
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/5/17 17:12
 **/
@EnableAsync
@SpringBootApplication
public class SimpleInitApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleInitApplication.class, args);
    }
}
