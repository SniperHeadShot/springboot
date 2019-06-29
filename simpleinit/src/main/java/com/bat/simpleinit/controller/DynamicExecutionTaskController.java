package com.bat.simpleinit.controller;

import com.bat.common.response.CommonResult;
import com.bat.simpleinit.service.DynamicExecutionTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 动态执行Task任务
 *
 * @author ZhengYu
 * @version 1.0 2019/6/29 9:17
 **/
@RestController
public class DynamicExecutionTaskController {

    @Autowired
    private DynamicExecutionTaskService dynamicExecutionTaskService;

    @GetMapping("/dynamic/task/start")
    public CommonResult startDynamicTask(@RequestParam(value = "param") String param) {
        return dynamicExecutionTaskService.startDynamicTask(param);
    }

    @GetMapping("/dynamic/task/stop")
    public CommonResult stopDynamicTask(@RequestParam(value = "param") String param) {
        return dynamicExecutionTaskService.stopDynamicTask(param);
    }
}
