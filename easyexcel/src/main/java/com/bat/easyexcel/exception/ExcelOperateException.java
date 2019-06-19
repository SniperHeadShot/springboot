package com.bat.easyexcel.exception;

/**
 * Excel 处理异常
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 16:52
 **/
public class ExcelOperateException extends RuntimeException {

    public ExcelOperateException(String message) {
        super(message);
    }
}
