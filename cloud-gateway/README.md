# 知识点
1. 为什么选用Gateway
    1. 非阻塞，响应式编程支持
    1. Spring cloud开源，支持较好,易用（相较zuul2还未推出）
    1. 性能好
1. 网关的概念
    1. Route（路由）
    1. Predicate（断言）
    1. Filter（过滤）

1. Gateway路由的实现方式
    1. 配置方式
    1. 编码方式
    
1. Gateway断言Predicate的11种方式 
    1. After
    1. Before
    1. Between
    1. Cookie
    1. Header
    1. Host
    1. Method
    1. Path
    1. Query
    1. ReadBodyPredicateFactory
    1. RemoteAddr
    1. Weight
    1. CloudFoundryRouteService
    
1. Gateway过滤器的生命周期
    1. 前置pre
    1. 后置post
    
1. Gateway过滤器的种类
    1. GatewayFilter单一配置，31种
    1. GlobalFilter全局配置，10种
    1. 自定义过滤器
