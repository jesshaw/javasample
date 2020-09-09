# 知识点
1. Hystrix
    1. 服务降级(fallback)。程序运行异常，超时，服务熔断，线程澉/信号量打满等会导致降级。
    1. 服务熔断(break)。达到最大访问后，拒绝服务，然后降级处理。步骤：降级-》熔断-》恢复调用链路。
    1. 服务限流(flow limit)。高并发等操作，排队有序进行。
    1. 接近实时的监控.....
  
1. JMeter压测工具
    1. Mac中直接terminal输入JMeter运行
 
1. 高并发导致客户端访问变慢（转圈圈）的解决方案
    1. 超时须降级
    1. 服务宕机须降级
    1. 调用方出故障或自我有要求须降级
    
1. @HystrixCommand实现服务端超时和异常降级
    1. main对应类加@EnableCircuitBreaker注解
    2. 实现@HystrixCommand注解的fallback方法和属性配置

1. @HystrixCommand中的熔断circuitBreaker
    1. HystrixCommandProperties属性值，三个重要参数：快照时间窗，请求总数阀值，错误百分比阀值



