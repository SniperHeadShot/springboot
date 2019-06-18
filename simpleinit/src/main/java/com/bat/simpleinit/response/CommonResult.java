package com.bat.response;

import com.bat.enums.ConstantEnum;
import lombok.Data;

/**
 * @ClassName CommonResult
 * @Description 通用返回结构体
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/5/24 17:41
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
