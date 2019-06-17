package com.bat.plupload.util;

/**
 * 通用的工具类
 *
 * @author ZhengYu
 * @version 1.0 2019/6/17 15:33
 **/
public class CommonUtils {

    /**
     * 获取系统运行环境
     *
     * @return java.lang.String
     * @author ZhengYu
     */
    public static String getRunSystem() {
        String osName = System.getProperty("os.name");
        String runSystemMac = "os.name";
        String runSystemWindows = "Windows";
        if (osName.startsWith(runSystemMac)) {
            return "mac";
        } else if (osName.startsWith(runSystemWindows)) {
            return "windows";
        } else {
            return "linux";
        }
    }
}
