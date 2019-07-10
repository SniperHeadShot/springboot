package com.bat.quartz.config;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 定时任务管理类
 *
 * @author ZhengYu
 * @version 1.0 2019/7/10 20:32
 **/
public class QuartzManager {

    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    public static void addJob(String jobName, Class jobClass, String timeCron, String projectUuid) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
