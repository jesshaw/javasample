# 知识点
1. sentinel 集成了Hystrix的各种功能，并在此基础上增加更加完善的功能。
1. sentinel 属于懒加载机制，
1. 流控规则有2种阈值类型：QPS和线程数。有3种流控模式：直接，关联和链路。有3种流控效果：快速失败，Warm Up(预热),排队等待
   1. 直接：api达到限流条件时，直接限流
   1. 关联:当关联的资源达到阈值时，就限流自己
   1. 只记录指定链路上的流量（指定资源从入口资源进来的流量，如果达到阈值，就进行限流）【api级别的针对来源】
   1. Warm Up默认coldFactor为3。因为若设置单机阀值为10QPS，那么初始能承受的QPS数是3，经过预热时长之后能承受的QPS为10。
1. 降级规则有3种熔断策略：慢调用比例，异常比例，异常数。
1. SentinelResource注解主管sentinel的配置，对于代码运行时异常不做处理。
1. 系统规则有5种类型：LOAD，RT，线程数，入口QPS，CPU使用率。
1. 数据持久化Nacos
    因为需要手动配置，所以可以考虑在Sentinel Dashboard上实现编辑的时候直接提交到nacos. 具体可参考：https://github.com/sonake/sentinel-dashboard-rebulid
