package com.bat.basicgrammar.menu002.method2.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * ImportSelector 使容器动态导入 N 个 Bean
 *
 * @author ZhengYu
 * @version 1.0 2019/12/2 16:36
 **/
public class CustomImportSelector implements ImportSelector {

    /**
     * ImportSelector 使容器动态导入 N 个 Bean
     *
     * @param importingClassMetadata 参数
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                "com.bat.basicgrammar.menu002.common.NeedInjectedBean1",
                "com.bat.basicgrammar.menu002.common.NeedInjectedBean2",
                "com.bat.basicgrammar.menu002.common.NeedInjectedBean3"
        };
    }
}
