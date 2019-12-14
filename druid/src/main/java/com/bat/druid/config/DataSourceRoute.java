package com.bat.druid.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 数据源配置
 * spring 使用AbstractRoutingDataSource自定义动态数据源时的事务处理, 需要继承spring的AbstractRoutingDataSource定义自己的动态数据源，可以根据需要动态的切换不同数据库的数据源
 *
 * @author ZhengYu
 * @version 1.0 2019/12/9 17:01
 **/
public class DataSourceRoute extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getRouteKey();
    }
}