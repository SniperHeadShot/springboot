package com.bat.basicgrammar.menu003.config;

import com.bat.basicgrammar.menu003.common.NeedInjectedBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 使用@Conditional注解动态实现当前配置是否生效
 *
 * @author ZhengYu
 * @version 1.0 2019/12/2 17:31
 **/
@Configuration
@Conditional(value = CustomCondition.class)
public class ConditionalConfig {

    @Bean
    public NeedInjectedBean needInjectedBean() {
        return new NeedInjectedBean();
    }
}
