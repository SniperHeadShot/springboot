package com.bat.springdatajpa.util;

import java.util.UUID;

/**
 * 工具类
 *
 * @author ZhengYu
 * @version 1.0 2019/6/18 14:09
 **/
public class CommonUtils {

    /**
     * UUID 生成器
     *
     * @return java.lang.String
     * @author ZhengYu
     */
    public static String getRandomUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
