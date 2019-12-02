package com.bat.basicgrammar.menu002.method3.config;

import com.bat.basicgrammar.menu002.common.NeedInjectedBean1;
import com.bat.basicgrammar.menu002.common.NeedInjectedBean2;
import com.bat.basicgrammar.menu002.common.NeedInjectedBean3;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * ImportBeanDefinitionRegistrar 也是一个接口，它可以手动注册bean到容器中，从而我们可以对类进行个性化的定制
 *
 * @author ZhengYu
 * @version 1.0 2019/12/2 16:52
 **/
public class CustomImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * ImportBeanDefinitionRegistrar 也是一个接口，它可以手动注册bean到容器中，从而我们可以对类进行个性化的定制
     *
     * @param importingClassMetadata annotation metadata of the importing class
     * @param registry               current bean definition registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition rootBeanDefinition1 = new RootBeanDefinition(NeedInjectedBean1.class);
        registry.registerBeanDefinition("needInjectedBean1", rootBeanDefinition1);

        RootBeanDefinition rootBeanDefinition2 = new RootBeanDefinition(NeedInjectedBean2.class);
        registry.registerBeanDefinition("needInjectedBean2", rootBeanDefinition2);

        RootBeanDefinition rootBeanDefinition3 = new RootBeanDefinition(NeedInjectedBean3.class);
        registry.registerBeanDefinition("needInjectedBean3", rootBeanDefinition3);
    }
}
