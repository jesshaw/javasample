# 知识点
1. pom及dependencyManagement。

1. lombok省出繁索的构造，get, set 等。须安装插件和引入

1. mybatis orm

1. Run Dashboard

1. 热启动
    1. adding devtools to your project pom.xml
    1. adding plugin to your pom.xml 
    1. enabling automatic build
    1. update the value
    1 restart idea
    
1. EnableDiscoveryClient

1. Sleuth 链路跟踪，用于查看各节点调用关系
   1. 一键启动zipkin
       ```
       docker run -d -p 9411:9411 --name myzipkin openzipkin/zipkin
       ```
   2. 增加sleuth zipkin坐标
   3. yml中配置zipkin服务器和采样值


