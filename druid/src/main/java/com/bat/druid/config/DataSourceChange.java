package com.bat.druid.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 数据源配置
 * spring 使用AbstractRoutingDataSource自定义动态数据源时的事务处理, 需要继承spring的AbstractRoutingDataSource定义自己的动态数据源，可以根据需要动态的切换不同数据库的数据源
 *
 * @author ZhengYu
 * @version 1.0 2019/12/9 17:01
 **/
@Configuration
public class DataSourceChange extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceRoute.getRouteKey();
    }

    public DataSourceChange() {
    }

    @Bean("test1")
    @Primary
    public DruidDataSource dataSource1() {
        return buildDataSource("com.mysql.jdbc.Driver", "jdbc:mysql://192.168.9.102:3306/test1?characterEncoding=utf8&useSSL=false", "root", "123");
    }

    @Bean("test2")
    public DruidDataSource dataSource2() {
        return buildDataSource("com.mysql.jdbc.Driver", "jdbc:mysql://192.168.9.102:3306/test2?characterEncoding=utf8&useSSL=false", "root", "123");
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