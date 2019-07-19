package com.bat.retry.guava;

import com.github.rholder.retry.RetryException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 重试功能 Service
 *
 * @author ZhengYu
 * @version 1.0 2019/7/19 11:22
 **/
@Slf4j
@Service
public class GuavaRetryService {

    @Autowired
    private RetryingConfig retryingConfig;

    public String run() {
        try {
            AtomicInteger atomicInteger = new AtomicInteger(1);
            return retryingConfig.<String>getRetryer().call(() -> {
                String result = atomicInteger.get() < 5 ? "fail" : "pass";
//                // 超过三次后抛出异常
//                int exceptionNum = 3;
//                if (atomicInteger.get() == exceptionNum) {
//                    throw new RuntimeException("重试次数到达阀值触发异常警告");
//                }
//                // 第四次抛出自定义异常
//                if (atomicInteger.get() == exceptionNum+1) {
//                    throw new ParameterVerificationNotPassException("自定义异常");
//                }

                log.info("第 [{}] 次重试, 获取的结果为 [{}]", atomicInteger.getAndIncrement(), result);
                return result;
            });
        } catch (ExecutionException | RetryException e) {
            log.error("重试出错", e);
        }
        return null;
    }
}
