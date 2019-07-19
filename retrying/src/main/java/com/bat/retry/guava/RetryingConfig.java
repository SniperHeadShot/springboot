package com.bat.retry.guava;

import com.bat.common.exceptions.ParameterVerificationNotPassException;
import com.github.rholder.retry.Attempt;
import com.github.rholder.retry.RetryListener;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 重试配置类
 *
 * @author ZhengYu
 * @version 1.0 2019/7/19 11:00
 **/
@Slf4j
@Component
public class RetryingConfig {

    public <T> Retryer<T> getRetryer() {
        return RetryerBuilder.<T>newBuilder()
                // 根据结果判断是否重试 - 满足条件则触发重试操作
                .retryIfResult(result -> Objects.equals(result, "fail"))

                // 根据异常判断是否重试 - 符合异常类型会停止重试操作
                .retryIfRuntimeException()
                .retryIfExceptionOfType(ParameterVerificationNotPassException.class)

                // 重试策略 - 设定无限重试
                // .withStopStrategy(StopStrategies.neverStop())
                // 重试策略 - 设定最大的重试次数
                .withStopStrategy(StopStrategies.stopAfterAttempt(5))

                // 等待策略 - 设定重试等待固定时长策略 [每次重试间隔为100ms]
                // .withWaitStrategy(WaitStrategies.fixedWait(100, TimeUnit.MILLISECONDS))
                // 等待策略 - 设定重试等待时长固定增长策略 [重试间隔为 200ms 300ms 400ms 500ms]
                // .withWaitStrategy(WaitStrategies.incrementingWait(200, TimeUnit.MILLISECONDS, 100, TimeUnit.MILLISECONDS))
                // 等待策略 - 设定重试等待时长按指数增长策略
                // .withWaitStrategy(WaitStrategies.exponentialWait(100, 1000, TimeUnit.MILLISECONDS))
                // 等待策略 - 组合重试等待时长策略
                .withWaitStrategy(WaitStrategies.join(WaitStrategies.fixedWait(100, TimeUnit.MILLISECONDS), WaitStrategies.exponentialWait(100, 1000, TimeUnit.MILLISECONDS)))

                // 监听器 - RetryListener实现重试过程细节处理
                .withRetryListener(getRetryListener())

                .build();
    }

    private RetryListener getRetryListener() {
        return new RetryListener() {
            @Override
            public <V> void onRetry(Attempt<V> attempt) {
                log.info("第 [{}] 次重试, 距离第一次重试的延迟为 [{}]", attempt.getAttemptNumber(), attempt.getDelaySinceFirstAttempt());
                log.info("返回的结果 [{}]", attempt.getResult());
            }
        };
    }
}
