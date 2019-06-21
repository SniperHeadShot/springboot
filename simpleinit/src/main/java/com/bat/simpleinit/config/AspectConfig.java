package com.bat.simpleinit.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 切面编程配置类
 *
 * @author ZhengYu
 * @version 1.0 2019/6/21 13:06
 **/
@Aspect
@Component
public class AspectConfig {

    private Logger logger = LoggerFactory.getLogger(AspectConfig.class);

    @Pointcut("execution(* com.bat.simpleinit.controller.*.*(..))")
    public void execute() {

    }

    @Before("execute()")
    public void before(JoinPoint joinPoint) throws Throwable {
        logger.info("前置通知...");
    }

    @AfterReturning(returning = "obj", pointcut = "execute()")
    public void after(Object obj) throws Throwable {
        logger.info("后置通知...");
    }

    @Around("execute()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("环绕通知...");
        return proceedingJoinPoint.proceed();
    }
}
