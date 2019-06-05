package com.bat.service;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName AsyncService
 * @Description 异步执行任务
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/6/5 9:55
 **/
@Service
public class AsyncService {

    /**
     * 传统使用线程池方式
     *
     * @param
     * @return void
     * @author ZhengYu
     * @date 2019/6/5
     */
    public void traditionalAsyncTask() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("async-pool-task-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1024), threadFactory, new ThreadPoolExecutor.AbortPolicy());

        threadPoolExecutor.execute(() -> {
            //do something!
            System.out.println(Thread.currentThread().getName() + " 业务逻辑");
        });
    }

    /**
     * SpringBoot 使用线程池方式
     *
     * @param
     * @return void
     * @author ZhengYu
     * @date 2019/6/5
     */
    @Async
    public void springBootAsyncTask() {
        //do something!
        System.out.println(Thread.currentThread().getName() + " 业务逻辑");
    }

    /**
     * SpringBoot 使用线程池方式[异常处理]
     *
     * @param
     * @return void
     * @author ZhengYu
     * @date 2019/6/5
     */
    @Async
    public void springBootAsyncTaskException() {
        //do something!
        throw new RuntimeException("测试异步异常处理!");
    }
}
