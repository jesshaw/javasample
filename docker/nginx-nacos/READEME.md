## nginx.conf 一定要下载不同操作系统下的版本，否则启动不起来

下载地址： http://nginx.org/en/download.html 

## 注意 nginx.conf.md 只是一些功能说明，版本跟nginx.conf不对应的




    upstream tomcats {
        server localhost:8088 weight=1;
        server localhost:8089 weight=1;
    }




        location / {
            proxy_pass http://tomcats;
            proxy_set_header Host $host;
            index  index.html index.htm;
        }
