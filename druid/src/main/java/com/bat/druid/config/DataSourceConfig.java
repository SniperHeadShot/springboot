package com.bat.druid.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 数据源配置
 *
 * @author ZhengYu
 * @version 1.0 2019/12/9 17:01
 **/
public class DataSourceConfig extends AbstractRoutingDataSource {



    @Override
    protected Object determineCurrentLookupKey() {

        return null;
    }

    private DruidDataSource buildDruidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }
}