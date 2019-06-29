package com.bat.simpleinit.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * 动态开启/关闭Task
 *
 * @author ZhengYu
 * @version 1.0 2019/6/29 12:48
 **/
@Slf4j
@Component
public class DynamicExecutionTaskUtil {

    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private Map<String, ScheduledFuture<?>> systemTaskMap = new ConcurrentHashMap<>();

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
    }

    /**
     * 动态开启 新的Task任务
     *
     * @param uniqueKey 必须唯一的任务标示符
     * @param runnable  任务
     * @param cron      执行周期
     * @return boolean
     * @author ZhengYu
     */
    public boolean openDynamicTask(String uniqueKey, Runnable runnable, String cron) {
        if (StringUtils.isEmpty(uniqueKey) || StringUtils.isEmpty(cron) || runnable == null) {
            return false;
        }
        boolean cancelTaskFlag = closeDynamicTask(uniqueKey);
        if (!cancelTaskFlag) {
            return false;
        }
        ScheduledFuture<?> schedule = threadPoolTaskScheduler.schedule(runnable, new CronTrigger(cron));
        log.info("定时任务 uniqueKey=[{}] cron=[{}] 创建成功", uniqueKey, cron);
        systemTaskMap.put(uniqueKey, schedule);
        return true;
    }

    /**
     * 动态关闭 Task任务
     *
     * @param uniqueKey 必须唯一的任务标示符
     * @return boolean
     * @author ZhengYu
     */
    public boolean closeDynamicTask(String uniqueKey) {
        if (StringUtils.isEmpty(uniqueKey)) {
            return false;
        }
        ScheduledFuture<?> scheduledFuture = systemTaskMap.get(uniqueKey);
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return true;
        }
        boolean cancelTaskFlag = scheduledFuture.cancel(true);
        if (!cancelTaskFlag) {
            log.info("定时任务 uniqueKey=[{}] 关闭失败", uniqueKey);
        }
        return cancelTaskFlag;
    }
}
