# db升级概述

## 范围

适用于mysql

## 最佳实践

### 已有数据库

1. nacos打开数据升级项, 升级完成后建议关掉
   spring.liquibase.enabled= true。
1. 先生成初始脚本
    ```bash
        cd ****module
        mvn compile liquibase:generateChangeLog
    ```
1. 检查是否有以下情况
    - json类型。用手json替换
    - 如有外键最好去除
    - 有表或字段变改需要改为手写
1. 增加前置检查
1. 每一个文件最后增加一个版本号用于回滚
1. 开发环境检查执行情况
    ```bash
        cd ****module
        mvn compile liquibase:update
    ```
