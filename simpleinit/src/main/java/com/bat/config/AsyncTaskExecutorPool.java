package com.bat.config;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * @ClassName AsyncTaskExecutorPool
 * @Description 线程池配置类
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/6/5 9:33
 **/
@Configuration
public class AsyncTaskExecutorPool implements AsyncConfigurer {

    private Logger logger = LoggerFactory.getLogger(AsyncTaskExecutorPool.class);

    @Autowired
    private TaskThreadPoolConfig taskThreadPoolConfig;

    /**
     * 配置线程池
     *
     * @param
     * @return java.util.concurrent.Executor
     * @author ZhengYu
     * @date 2019/6/5
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(taskThreadPoolConfig.getCorePoolSize());
        threadPoolTaskExecutor.setMaxPoolSize(taskThreadPoolConfig.getMaxPoolSize());
        threadPoolTaskExecutor.setQueueCapacity(taskThreadPoolConfig.getQueueCapacity());
        threadPoolTaskExecutor.setKeepAliveSeconds(taskThreadPoolConfig.getKeepAliveSeconds());
        threadPoolTaskExecutor.setThreadNamePrefix(taskThreadPoolConfig.getThreadNamePrefix());
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    /**
     * 配置线程任务异常处理
     *
     * @param
     * @return org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
     * @author ZhengYu
     * @date 2019/6/5
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (Throwable throwable, Method method, Object... objects) -> {
            logger.error("==================== Async Thread Task Error Start ====================");
            logger.error("error message =====> :{}", throwable.getMessage());
            logger.error("error method ======> :{}", method.getName());
            logger.error("error parameter ===> :{}", JSONObject.toJSONString(objects));
            logger.error("", throwable);
            logger.error("==================== Async Thread Task Error End ====================");
        };
    }
}
