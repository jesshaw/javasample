# 知识点
1. config中 bootstrap.yml先于 application.yml加载。即最近优先原则

1. git配置变改时，服务器config会即时变改，但客户端不会时怎么解决。
    1. 开启暴露监控端点
    1. 增加@RefreshScope注解
    1. 发送确认post，确认刷新。 curl -X POST "http://localhost:3355/actuator/refresh"


    
