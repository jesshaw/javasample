# 知识点

    ``` 
    
1.  创建一个网络方便容器间当前机器下查找访问
    ```
    docker network create mynet
    ```
    
1.  查看现有网络列表
    ```
    docker network ls
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

1. Dockerfile 定制镜像
   1. 参考： https://yeasy.gitbook.io/docker_practice/image/build

1. docker-compose 模板参考
   1. 参考：https://yeasy.gitbook.io/docker_practice/compose/compose_file
    
1. Dockerfile RUN 不能多,会分层

1. 清除无用的镜像(dangling image) 
    ```
    docker image prune  
    ```
    
1. 清除已终止的容器 
    ```
    docker image prune  
    ```

