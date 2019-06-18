package com.bat.simpleinit.controller;

import com.bat.simpleinit.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异步处理任务 测试类
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:09
 **/
@RestController
public class AsyncDemonstrateController {

    @Autowired
    private AsyncService asyncService;

    /**
     * 传统使用线程池方式
     *
     * @author ZhengYu
     * @date 2019/6/5
     */
    @GetMapping("/async/tradition")
    public void traditionalAsyncTask() {
        this.asyncService.traditionalAsyncTask();
    }

    /**
     * SpringBoot 使用线程池方式
     *
     * @author ZhengYu
     * @date 2019/6/5
     */
    @GetMapping("/async/springboot")
    public void springBootAsyncTask() {
        this.asyncService.springBootAsyncTask();
    }

    /**
     * SpringBoot 使用线程池方式
     *
     * @author ZhengYu
     * @date 2019/6/5
     */
    @GetMapping("/async/springboot/exception")
    public void springBootAsyncTaskException() {
        this.asyncService.springBootAsyncTaskException();
    }
}