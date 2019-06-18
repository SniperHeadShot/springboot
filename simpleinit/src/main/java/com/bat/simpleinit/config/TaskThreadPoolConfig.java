package com.bat.simpleinit.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 线程池参数配置类
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:09
 **/
@Configuration
@ConfigurationProperties(prefix = "spring.task.pool")
@Data
public class TaskThreadPoolConfig {

    private Integer corePoolSize;

    private Integer maxPoolSize;

    private Integer keepAliveSeconds;

    private Integer queueCapacity;

    private String threadNamePrefix;
}
