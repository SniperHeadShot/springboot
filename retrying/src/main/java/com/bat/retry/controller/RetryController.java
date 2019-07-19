package com.bat.retry.controller;

import com.bat.common.enums.ConstantEnum;
import com.bat.common.response.CommonResult;
import com.bat.retry.guava.GuavaRetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制层
 *
 * @author ZhengYu
 * @version 1.0 2019/7/19 13:40
 **/
@RestController
public class RetryController {

    @Autowired
    private GuavaRetryService guavaRetryService;

    @GetMapping("/retry/guava")
    public CommonResult<String> guavaRetry() {
        String result = guavaRetryService.run();
        return CommonResult.buildCommonResult(ConstantEnum.GLOBAL_SUCCESS, result);
    }
}
