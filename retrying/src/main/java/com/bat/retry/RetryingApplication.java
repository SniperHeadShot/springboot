package com.bat.retry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 需要重试的方法
 *
 * @author ZhengYu
 * @version 1.0 2019/7/19 10:53
 **/
@SpringBootApplication
public class RetryingApplication {
    public static void main(String[] args) {
        SpringApplication.run(RetryingApplication.class, args);
    }
}
