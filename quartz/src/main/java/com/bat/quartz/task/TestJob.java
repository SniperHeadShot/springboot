package com.bat.quartz.task;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 定时任务实现类
 *
 * @author ZhengYu
 * @version 1.0 2019/7/11 1:16
 **/
@Slf4j
public class TestJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("读取到参数 ===> [{}]", jobExecutionContext.getJobDetail().getJobDataMap().get("projectUuid"));
    }
}
