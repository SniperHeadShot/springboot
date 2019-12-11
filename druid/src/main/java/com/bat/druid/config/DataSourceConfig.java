package com.bat.druid.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据源配置
 *
 * @author ZhengYu
 * @version 1.0 2019/12/10 13:42
 **/
@Configuration
public class DataSourceConfig {


    @Bean("test1")
    @Primary
    public DruidDataSource dataSource1() {
        return buildDataSource("com.mysql.jdbc.Driver", "jdbc:mysql://192.168.9.102:3306/test1?characterEncoding=utf8&useSSL=false", "root", "123");
    }

    @Bean("test2")
    public DruidDataSource dataSource2() {
        return buildDataSource("com.mysql.jdbc.Driver", "jdbc:mysql://192.168.9.102:3306/test2?characterEncoding=utf8&useSSL=false", "root", "123");
    }

    @Bean(name = "dataSourceRoute")
    public DataSourceRoute dataSourceChange() {
        // 生成结果
        Map<Object, Object> result = new HashMap<>(2);
        result.put("test1", dataSource1());
        result.put("test2", dataSource2());

        DataSourceRoute dataSourceRoute = new DataSourceRoute();
        dataSourceRoute.setTargetDataSources(result);
        dataSourceRoute.setDefaultTargetDataSource(dataSource1());
        return dataSourceRoute;
    }


    private DruidDataSource buildDataSource(String driverClass, String url, String username, String password) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClass);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(10);
        druidDataSource.setMinIdle(5);
        druidDataSource.setMaxActive(100);
        druidDataSource.setMaxWait(30000);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setValidationQuery("SELECT 1 FROM DUAL");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(true);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setPoolPreparedStatements(true);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        return druidDataSource;
    }
}