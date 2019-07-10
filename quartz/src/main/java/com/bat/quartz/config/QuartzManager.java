package com.bat.quartz.config;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 定时任务管理类
 *
 * @author ZhengYu
 * @version 1.0 2019/7/10 20:32
 **/
public class QuartzManager {

    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    public static void addJob(Class<? extends Job> jobClass, String projectUuid) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            JobDetail jobDetail = JobBuilder.newJob(jobClass)
                    .withIdentity("job_" + projectUuid, "jobGroup_" + projectUuid)
                    .build();
            jobDetail.getJobDataMap().put("projectUuid", projectUuid);
            CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger_" + projectUuid, "triggerGroup_" + projectUuid)
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                    .build();
            scheduler.scheduleJob(jobDetail, cronTrigger);

            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
