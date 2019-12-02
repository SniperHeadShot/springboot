package com.bat.basicgrammar.menu002.method3;

import com.bat.basicgrammar.menu002.method3.config.CustomImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * ImportBeanDefinitionRegistrar 也是一个接口，它可以手动注册bean到容器中，从而我们可以对类进行个性化的定制
 *
 * @author ZhengYu
 * @version 1.0 2019/12/2 16:55
 **/
@Import(CustomImportBeanDefinitionRegistrar.class)
@Configuration
public class ImportBeanDefinitionRegistrar {
}
