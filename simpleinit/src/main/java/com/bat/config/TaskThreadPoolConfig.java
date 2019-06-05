package com.bat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName TaskThreadPoolConfig
 * @Description 线程池参数配置类
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/6/5 9:14
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
