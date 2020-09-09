# 知识点
1. 搭建zookeeper单机版
   mac验证此方式可行，参考官网安装：https://zookeeper.apache.org/doc/r3.6.1/zookeeperStarted.html
   ```bash
   $ cd /usr/local/apache-zookeeper-3.6.1
   $ cp ./config/zoo_sample.cfg ./config/zoo.cfg
   $ ./bin/zkServer.sh start
   $ ./bin/zkCli.sh -server localhost:2181
   $ ls /
   ```

1. 连接zookeeper
    /usr/local/Cellar/zookeeper/3.5.7/bin/zkCli
