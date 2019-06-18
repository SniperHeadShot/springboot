package com.bat.simpleinit.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 自定义的 /actuator/health 指标项
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:09
 **/
@Component
public class CustomizeActuatorHealth implements HealthIndicator {

    @Override
    public Health health() {
        //这里加一些自定义的指标，像数据中心的连接是否超时等指标
        Random random = new Random();
        return random.nextInt(10) < 5 ? Health.down().withDetail("code", "1001").withDetail("msg", "某自定义指标未达标").build() : Health.up().build();
    }
}
