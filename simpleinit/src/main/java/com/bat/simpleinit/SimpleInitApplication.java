package com.bat.simpleinit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Springboot基础知识演示
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:09
 **/
@EnableAsync
@SpringBootApplication
public class SimpleInitApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleInitApplication.class, args);
    }
}
