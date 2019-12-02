package com.bat.basicgrammar.menu002.method1;

import com.bat.basicgrammar.menu002.common.NeedInjectedBean1;
import com.bat.basicgrammar.menu002.common.NeedInjectedBean2;
import com.bat.basicgrammar.menu002.common.NeedInjectedBean3;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 使用 @Import 导入普通 java 类，并将其声明成一个bean
 *
 * @author ZhengYu
 * @version 1.0 2019/12/2 16:23
 **/
@Import({NeedInjectedBean1.class, NeedInjectedBean2.class, NeedInjectedBean3.class})
@Configuration
public class UseImportAnnotation {
}
