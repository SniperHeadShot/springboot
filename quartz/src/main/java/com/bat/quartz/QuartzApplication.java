package com.bat.quartz;

import com.bat.quartz.config.QuartzManager;
import com.bat.quartz.task.TestJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot启动主类
 *
 * @author ZhengYu
 * @version 1.0 2019/7/10 20:30
 **/
@SpringBootApplication
public class QuartzApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class, args);

        QuartzManager.addJob(TestJob.class,"123456");
        QuartzManager.addJob(TestJob.class,"654321");
    }
}
