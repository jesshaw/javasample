# 知识点

1. 重复消费的问题怎么解决
   1. 配置消费端使用同一个组消费即解决了重复消费的问题
1. 持久化
    一台机器宕机不会导致消息丢失，只要存在对应的消息组在线可以继续消费。