package com.bat.simpleinit.exceptions;

/**
 * 参数校验未通过通用异常
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:09
 **/
public class ParameterVerificationNotPassException extends RuntimeException {

    /**
     * 参数校验未通过通用异常
     *
     * @param message 异常信息
     * @author ZhengYu
     */
    public ParameterVerificationNotPassException(String message) {
        super(message);
    }
}
