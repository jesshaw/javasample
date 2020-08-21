## 列出所有端口，并查找点用商品的进程
```
 NETSTAT -aon|findstr "3306"

  TCP    0.0.0.0:3306           0.0.0.0:0              LISTENING       14256
  TCP    [::]:3306              [::]:0                 LISTENING       14256
```
 MYSQL_ALLOW_EMPTY_PASSWORD=yes

## 据进程号查找对应的应用名
```
tasklist | findstr "14256" 
