# 知识点

1. Nacos(NAme+COnfig+Service)解决什么问题
   
   1. 注册中心名称管理
   1. 配置管理
   1. 服务管理如bus消息通知

1. Nacos安装
   
   存放路径 /usr/local
    ```
    $ sudo tar -xvf nacos-server-$version.tar.gz
    $ sudo cd nacos/bin
    $ sudo sh startup.sh -m standalone
    $ sudo sh shutdown.sh
    ```
    
1. dockertags显示指定镜偈的所有tags
    1. /usr/local/bin目录下新增 dockertags 文件
    1. 增加以下内容
        ```
        #!/bin/bash
        
        if [ $# -lt 1 ]
        then
        cat << HELP
        
        dockertags  --  list all tags for a Docker image on a remote registry.
        
        EXAMPLE: 
            - list all tags for ubuntu:
               dockertags ubuntu
        
            - list all php tags containing apache:
               dockertags php apache
        
        HELP
        fi
        
        image="$1"
        tags=`wget -q https://registry.hub.docker.com/v1/repositories/${image}/tags -O -  | sed -e 's/[][]//g' -e 's/"//g' -e 's/ //g' | tr '}' '\n'  | awk -F: '{print $3}'`
        
        if [ -n "$2" ]
        then
            tags=` echo "${tags}" | grep "$2" `
        fi
        
        echo "${tags}"
        ```
    1. 给dockertags授权(chmod +x dockertags)
    1. 在.bashrc/.zshrc增加环境变量到PATH路径。
    1. dockertags openjdk
    
    参考： https://stackoverflow.com/questions/28320134/how-can-i-list-all-tags-for-a-docker-image-on-a-remote-registry#
   
1. docker search example 查询含有example的镜像并列出来
