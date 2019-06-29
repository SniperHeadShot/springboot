package com.bat.simpleinit.service;

import com.bat.common.enums.ConstantEnum;
import com.bat.common.exceptions.ParameterVerificationNotPassException;
import com.bat.common.response.CommonResult;
import com.bat.simpleinit.util.DynamicExecutionTaskUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 动态执行Task任务
 *
 * @author ZhengYu
 * @version 1.0 2019/6/29 9:25
 **/
@Slf4j
@Service
public class DynamicExecutionTaskService {

    private static final String CRON = "0/1 * * * * *";

    @Autowired
    private DynamicExecutionTaskUtil dynamicExecutionTaskUtil;

    public CommonResult startDynamicTask(String param) {
        if (StringUtils.isEmpty(param)) {
            throw new ParameterVerificationNotPassException("必填参数为空!");
        }
        String uniqueKey = "dynamic_task_" + param;
        boolean openDynamicTaskFlag = dynamicExecutionTaskUtil.openDynamicTask(uniqueKey, () -> {
            // do something
            System.out.println("do something");
        }, CRON);
        return CommonResult.buildCommonResult(openDynamicTaskFlag ? ConstantEnum.GLOBAL_SUCCESS : ConstantEnum.GLOBAL_FAIL);
    }

    public CommonResult stopDynamicTask(String param) {
        String uniqueKey = "dynamic_task_" + param;
        boolean closeDynamicTaskFlag = dynamicExecutionTaskUtil.closeDynamicTask(uniqueKey);
        return CommonResult.buildCommonResult(closeDynamicTaskFlag ? ConstantEnum.GLOBAL_SUCCESS : ConstantEnum.GLOBAL_FAIL);
    }
}
