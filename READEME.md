SpringBoot 
===========================
SpringBoot 整理总结

## 目录
* 基础语法[basicgrammar](#基础语法)
* 网络[network](#网络)


### 基础语法
#### menu001 @Value相关API

> 1. 从.yml或.properties配置文件中取值
> 2. 从JVM启动参数中取值
> 3. 从外部配置文件(.properties)中取值
> 4. 从配置文件中读取配置为静态变量

#### menu002 @Import 导入普通的java类，并将其声明成一个bean

> 三种将java类注入为IOC容器bean的方式
>   1. 直接导入普通的 Java 类
>   2. 配合自定义的 ImportSelector 使用
>   3. 配合 ImportBeanDefinitionRegistrar 使用

### 网络
#### menu001 FeignClient的使用

> 1. 已知服务地址，使用@FeignClient作为Http客户端去调用
> 2. 未知服务地址，需要动态获取服务地址，然后在使用@FeignClient作为Http客户端去调用