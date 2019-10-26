package com.bat.network;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 网络
 *
 * @author ZhengYu
 * @version 1.0 2019/10/26 16:23
 **/
@EnableFeignClients
@SpringBootApplication
public class NetWorkApplication {
    public static void main(String[] args) {
        SpringApplication.run(NetWorkApplication.class, args);
    }
}
