# 数据升级

分两部分，一部分为手动比对两库差异，别一部分为spring boot自动升级。

## 自动执行升级

### 本地打包

mvn package spring-boot:repackage

### 本地运行
mvn spring-boot:run

### 打包启动

不加install会找不到启动函数
mvn clean install 

java -jar target/**.jar


## mvn方式执行升级并打tag 走通

mvn compile liquibase:update liquibase:tag

mvn compile liquibase:dropAll

## 回滚1个版本

mvn liquibase:rollback -Dliquibase.rollbackTag=1.0

## 回滚1个版本

mvn liquibase:rollback -Dliquibase.rollbackCount=1


## 要看两个库的版本差异

mvn liquibase:diff -Dliquibase.diffTypes=tables,columns,indexes,primarykeys,uniqueconstraints

[maven diff ref](https://docs.liquibase.com/tools-integrations/maven/commands/maven-diff.html)

## 基于现有数据产生初始部署文件

mvn liquibase:generateChangeLog

[maven generatechangelog ref](https://docs.liquibase.com/tools-integrations/maven/commands/maven-generatechangelog.html)


## 查看帮助文件

mvn liquibase:help -Ddetail=true

[maven help ref](https://docs.liquibase.com/tools-integrations/maven/commands/maven-help.html)

## 删除db的所有对象，不包括函数，存储过程或程序包

mvn liquibase:dropAll

## 显示加锁的信息

mvn liquibase:listLocks

## 释放锁

mvn liquibase:releaseLocks

## 打tag

通常用于通过将标签添加到DATABASECHANGELOG表的最后一行来标记当前数据库状态 。

mvn liquibase:tag -Dliquibase.tag=myTag