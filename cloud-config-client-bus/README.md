# 前置条件

1. 搭建rabbit服务器
    
    注意:rabbit需暴露5672端口
    ```
        docker run -d --hostname my-rabbit --name some-rabbit -p 5672:5672 -p 15672:15672 rabbitmq:3-management
    ```
    
1. 须连网，因为访问git配置局

# 知识点
1. 设计思想是通过通知config配置中心进而通知所有客户端 
    1. 开启暴露监控端点
    1. 增加@RefreshScope注解
    1. 发送确认post给数据中心，确认刷新。
     通知所有机器 curl -X POST "http://localhost:3344/actuator/bus-refresh"
     指定机器通知 curl -X POST "http://localhost:3344/actuator/bus-refresh/cloud-config-client:3355"
    
