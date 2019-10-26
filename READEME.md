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


### 网络
#### menu001 FeignClient的使用

> 1. 已知服务地址，使用@FeignClient作为Http客户端去调用
> 2. 未知服务地址，需要动态获取服务地址，然后在使用@FeignClient作为Http客户端去调用