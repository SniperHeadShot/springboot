SpringBoot 
===========================
SpringBoot 整理总结

## 目录
* 基础语法[basicgrammar](#基础语法)
* Druid整合Mybatis[druid](#Druid)
* 网络[network](#网络)
* Spring[spring](#Spring)


### 基础语法
#### menu001 @Value相关API

> 1. 从.yml或.properties配置文件中取值
> 2. 从JVM启动参数中取值
> 3. 从外部配置文件(.properties)中取值
> 4. 从配置文件中读取配置为静态变量

#### menu002 三种将java类注入为IOC容器bean的方式

> 1. 使用@Import注解导入普通的 Java 类
> 2. 配合自定义的 ImportSelector 使用
> 3. 配合 ImportBeanDefinitionRegistrar 使用

#### menu003 @Condition注解的使用
> 1. @Conditional 注解可以实现只有在特定条件满足时才启用一些配置
> 2. @ConditionalOnBean 容器中存在指定Bean，则生效
> 3. @ConditionalOnMissingBean 容器中不存在指定Bean，则生效
> 4. @ConditionalOnClass 容器中有指定类，则生效
> 5. @ConditionalOnMissingClass 容器中没有指定类，则生效
> 6. @ConditionalOnProperty 系统中指定的属性是否有指定的值
> 7. @ConditionalOnWebApplication 当前是web环境，则生效

### Druid

> Druid 整合 Mybatis 实现运行时动态数据源切换

```
-DdataSourceMsg=[{\"host\":\"192.168.9.230\",\"port\":3306,\"username\":\"root\",\"password\":\"nYd*4M]ipIv+\",\"aimDb\":\"test\"},{\"host\":\"192.168.9.102\",\"port\":3306,\"username\":\"root\",\"password\":\"nYd*4M]ipIv+\",\"aimDb\":\"test\"}]
```

### 网络

#### menu001 FeignClient的使用

> 1. 已知服务地址，使用@FeignClient作为Http客户端去调用
> 2. 未知服务地址，需要动态获取服务地址，然后在使用@FeignClient作为Http客户端去调用

### Spring

#### menu001 