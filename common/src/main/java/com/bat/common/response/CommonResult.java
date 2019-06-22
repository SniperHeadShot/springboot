package com.bat.common.response;

import com.bat.common.enums.ConstantEnum;
import lombok.Data;

/**
 * 通用返回结构体
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:09
 **/
@Data
public class CommonResult<T> {

    private Boolean success;
    private Integer code;
    private String msg;
    private T data;

    private CommonResult(ConstantEnum constantEnum) {
        this.success = constantEnum.success();
        this.code = constantEnum.errCode();
        this.msg = constantEnum.msg();
    }

    private CommonResult(ConstantEnum constantEnum, String msg) {
        this.success = constantEnum.success();
        this.code = constantEnum.errCode();
        this.msg = msg;
    }

    public static CommonResult buildCommonResult(ConstantEnum constantEnum) {
        return new CommonResult(constantEnum);
    }

    public static CommonResult buildCommonResult(ConstantEnum constantEnum, String msg) {
        return new CommonResult(constantEnum, msg);
    }
}
