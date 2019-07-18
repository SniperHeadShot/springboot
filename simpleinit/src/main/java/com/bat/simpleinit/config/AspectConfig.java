package com.bat.simpleinit.config;

import com.alibaba.fastjson.JSONObject;
import com.bat.common.annotation.CustomMethodDesc;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 切面编程配置类
 *
 * @author ZhengYu
 * @version 1.0 2019/6/21 13:06
 **/
@Aspect
@Slf4j
@Component
public class AspectConfig {

    private volatile String methodCustomDesc = "";

    @Pointcut("execution(* com.bat.simpleinit.controller.*.*(..))")
    public void execute() {

    }

    @Before("execute()")
    public void before(JoinPoint joinPoint) throws Throwable {
        // 是否开启 DEBUG 打印
        if (log.isDebugEnabled()) {
            methodCustomDesc = getMethodCustomDesc(joinPoint);
            log.debug("[{}] 前置通知...", methodCustomDesc);
        }
    }

    @AfterReturning(returning = "obj", pointcut = "execute()")
    public void after(Object obj) {
        // 是否开启 DEBUG 打印
        if (log.isDebugEnabled()) {
            log.debug("[{}] 后置通知... 结果为 [{}]", methodCustomDesc, JSONObject.toJSONString(obj));
        }
    }

    @Around("execute()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 是否开启 DEBUG 打印
        if (log.isDebugEnabled()) {
            log.debug("[{}] 环绕通知...", getMethodCustomDesc(proceedingJoinPoint));
        }
        return proceedingJoinPoint.proceed();
    }

    /**
     * 获取自定义方法描述
     *
     * @param joinPoint 切点
     * @return java.lang.String
     * @author ZhengYu
     */
    private String getMethodCustomDesc(JoinPoint joinPoint) throws NoSuchMethodException {
        String resultMethodCustomDesc = "";
        Class<?> aspectClass = joinPoint.getTarget().getClass();
        Method aspectClassMethod = aspectClass.getMethod(joinPoint.getSignature().getName());
        aspectClassMethod.setAccessible(true);
        CustomMethodDesc declaredAnnotation = aspectClassMethod.getDeclaredAnnotation(CustomMethodDesc.class);
        if (declaredAnnotation != null) {
            resultMethodCustomDesc = declaredAnnotation.value();
        }
        return StringUtils.isEmpty(resultMethodCustomDesc) ? joinPoint.getSignature().toShortString() : resultMethodCustomDesc;
    }
}
