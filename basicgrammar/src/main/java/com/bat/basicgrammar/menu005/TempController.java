package com.bat.basicgrammar.menu005;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author ZhengYu
 * @version 1.0 2019/12/13 10:05
 **/
@RestController
public class TempController {

    @GetMapping("/test")
    public void test() {
        // 获取当前类的类加载器
        ClassLoader classClassLoader = TempController.class.getClassLoader();

        // 获取当前线程的上下文类加载器
        ClassLoader threadClassLoader = Thread.currentThread().getContextClassLoader();

        // 获取系统的类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        System.out.println(classClassLoader == threadClassLoader);
        System.out.println(classClassLoader == systemClassLoader);
        System.out.println(threadClassLoader == systemClassLoader);
    }
}
