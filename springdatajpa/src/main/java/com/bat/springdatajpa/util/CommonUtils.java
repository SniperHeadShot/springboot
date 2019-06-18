package com.bat.util;

import java.util.UUID;

/**
 * @ClassName CommonUtils
 * @Description 工具类
 * @Author ZhengYu
 * @Version: 1.0
 * @Create: 2019/5/22 10:40
 **/
public class CommonUtils {

    /**
     * @Param []
     * @Return java.lang.String
     * @Author ZhengYu
     * @Description: UUID 生成器
     * @Date 2019/5/22
     */
    public static String getRandomUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
