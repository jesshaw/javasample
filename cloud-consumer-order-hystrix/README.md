# 知识点
1. @HystrixCommand实现客户端超时和异常降级

1. @HystrixCommand 实现客户端超时和异常降级
    1. application.yml打开feign.hystrix.enabled开关
    1. main对应类加@EnableHystrix注解
    1. 实现@HystrixCommand注解的fallback方法和属性配置

1. 默认全局通用降级fallbak。@DefaultProperties

1. @HystrixCommand配置引起的代码膨胀，代码混乱
    1. @FeignClient注解上配置fallback类，实现接口的所有方法。对应的实现方法即是fallback实现
