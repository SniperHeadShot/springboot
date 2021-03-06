package com.bat.druid.config;

import lombok.extern.slf4j.Slf4j;

/**
 * 保存当前线程数据源的key
 *
 * @author ZhengYu
 * @version 1.0 2019/12/10 11:29
 **/
@Slf4j
public class DataSourceContextHolder {

    private static ThreadLocal<String> routeKey = new ThreadLocal<>();

    /**
     * 获取当前线程的数据源路由的key
     *
     * @return java.lang.String
     * @author ZhengYu
     */
    public static String getRouteKey() {
        return routeKey.get();
    }

    /**
     * 绑定当前线程数据源路由的key
     *
     * @author ZhengYu
     */
    public static void setRouteKey(String key) {
        log.info("datasource switch ==> [{}]", key);
        routeKey.set(key);
    }

    /**
     * 删除当前线程数据源路由的key
     *
     * @author ZhengYu
     */
    public static void removeRouteKey() {
        routeKey.remove();
    }
}
