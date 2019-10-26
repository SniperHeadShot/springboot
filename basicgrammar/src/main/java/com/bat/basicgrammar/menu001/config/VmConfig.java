package com.bat.basicgrammar.menu001.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 从JVM启动参数中取值
 *
 * @author ZhengYu
 * @version 1.0 2019/10/26 14:47
 **/
@Data
@Component
public class VmConfig {

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{systemProperties['PID']}")
    private Integer pid;
}
