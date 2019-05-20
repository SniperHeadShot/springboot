package com.bat.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @ClassName CustomizeActuatorHealth
 * @Description 自定义的 /actuator/health 指标项
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/5/20 13:59
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
