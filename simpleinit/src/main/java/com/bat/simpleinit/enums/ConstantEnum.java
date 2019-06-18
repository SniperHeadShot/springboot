package com.bat.simpleinit.enums;

import com.bat.simpleinit.annotation.CodeEntity;

/**
 * 返回值枚举
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:09
 **/
public enum ConstantEnum implements CodeEnumInterface {

    // 全局成功
    @CodeEntity(
            success = true,
            msg = "操作成功!"
    )
    GLOBAL_SUCCESS,

    // 全局失败
    @CodeEntity(
            success = false,
            errCode = -1,
            msg = "系统繁忙，请稍后再试!"
    )
    GLOBAL_FAIL,

    // 全局参数不完整
    @CodeEntity(
            success = false,
            errCode = 4000,
            msg = "参数不完整，请检查后再试!"
    )

    // 全局数据库执行失败
    PARAMETER_VERIFICATION_FAIL,
    @CodeEntity(
            success = false,
            errCode = 5000,
            msg = "数据库执行SQL失败!"
    )
    SQL_EXECUTE_FAIL
}
