package com.bat.druid.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSONObject;
import com.bat.commoncode.entity.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义
 *
 * @author ZhengYu
 * @version 1.0 2019/12/14 16:51
 **/
@Slf4j
public class CustomApplicationRunListener implements SpringApplicationRunListener {

    public CustomApplicationRunListener(SpringApplication application, String[] args) {
        log.info("constructor");
    }

    /**
     * Called immediately when the run method has first started. Can be used for very
     * early initialization.
     */
    @Override
    public void starting() {
        log.info("在run()方法开始执行时，该方法就立即被调用，可用于在初始化最早期时做一些工作");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        log.info("当environment构建完成，ApplicationContext创建之前，该方法被调用");
    }

    /**
     * Called once the {@link ApplicationContext} has been created and prepared, but
     * before sources have been loaded.
     *
     * @param context the application context
     */
    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        buildDataSource(context);
        log.info("当ApplicationContext构建完成时，该方法被调用");
    }

    /**
     * Called once the application context has been loaded but before it has been
     * refreshed.
     *
     * @param context the application context
     */
    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.info("在ApplicationContext完成加载，但没有被刷新前，该方法被调用");
    }

    /**
     * The context has been refreshed and the application has started but
     * {@link CommandLineRunner CommandLineRunners} and {@link ApplicationRunner
     * ApplicationRunners} have not been called.
     *
     * @param context the application context.
     * @since 2.0.0
     */
    @Override
    public void started(ConfigurableApplicationContext context) {
        log.info("在ApplicationContext刷新并启动后，CommandLineRunners和ApplicationRunner未被调用前，该方法被调用");
    }

    /**
     * Called immediately before the run method finishes, when the application context has
     * been refreshed and all {@link CommandLineRunner CommandLineRunners} and
     * {@link ApplicationRunner ApplicationRunners} have been called.
     *
     * @param context the application context.
     * @since 2.0.0
     */
    @Override
    public void running(ConfigurableApplicationContext context) {
        log.info("在run()方法执行完成前该方法被调用");
    }

    /**
     * Called when a failure occurs when running the application.
     *
     * @param context   the application context or {@code null} if a failure occurred before
     *                  the context was created
     * @param exception the failure
     * @since 2.0.0
     */
    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.info("当应用运行出错时该方法被调用");
    }

    private void buildDataSource(ConfigurableApplicationContext configurableApplicationContext) {
        // 读取数据源
        String dataSourceMsg = System.getProperty("dataSourceMsg");
        List<DataSource> dataSourceList = JSONObject.parseArray(dataSourceMsg, DataSource.class);
        log.info("datasource info ==> [{}]", JSONObject.toJSONString(dataSourceList));

        if (dataSourceList == null || dataSourceList.size() == 0) {
            return;
        }

        // 封装数据源
        Map<Object, Object> datasourceMap = new HashMap<>(dataSourceList.size());
        Object defaultDatasource = null;
        for (int i = 0; i < dataSourceList.size(); i++) {
            DruidDataSource druidDataSource = buildDataSource(dataSourceList.get(i));
            if (i == 0) {
                defaultDatasource = druidDataSource;
            }
            datasourceMap.put(dataSourceList.get(i).getUniqueKey(), druidDataSource);
        }

        // 将数据源路由对象交给Spring管理
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();
        BeanDefinitionBuilder routeBeanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(DataSourceRoute.class);
        routeBeanDefinitionBuilder.addPropertyValue("targetDataSources", datasourceMap);
        routeBeanDefinitionBuilder.addPropertyValue("defaultTargetDataSource", defaultDatasource);
        defaultListableBeanFactory.registerBeanDefinition("dataSourceRoute", routeBeanDefinitionBuilder.getRawBeanDefinition());
    }

    /**
     * 构造数据源[目前只适配了Mysql数据库]
     *
     * @author ZhengYu
     */
    private DruidDataSource buildDataSource(DataSource dataSource) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl(String.format("jdbc:mysql://%s:%d/%s?characterEncoding=utf8&useSSL=false", dataSource.getHost(), dataSource.getPort(), dataSource.getAimDb()));
        druidDataSource.setUsername(dataSource.getUsername());
        druidDataSource.setPassword(dataSource.getPassword());
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
