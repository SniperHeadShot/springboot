package com.bat.basicgrammar.menu004;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * StopWatch 主类
 *
 * @author ZhengYu
 * @version 1.0 2019/12/6 13:00
 **/
@Slf4j
@RestController
public class StopWatchController {

    @GetMapping("/test/stopwatch")
    public String doSomething() throws InterruptedException {
        StopWatch stopWatch = new StopWatch("StopWatch 测试");
        // 业务1
        stopWatch.start("业务1");
        Thread.sleep(1000);
        stopWatch.stop();

        // 业务2
        stopWatch.start("业务2");
        Thread.sleep(2000);
        stopWatch.stop();

        // 业务3
        stopWatch.start("业务3");
        Thread.sleep(3000);
        stopWatch.stop();

        log.info("prettyPrint() ==> [{}]", stopWatch.prettyPrint());

        log.info("toString() ==> [{}]", stopWatch.toString());
        return "succ";
    }
}
