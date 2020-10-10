# 知识点

## 以下是docker启动方法
docker build -t jesshaw/sentinel-1.8.0 .
docker run -d --name mysentinel-1.8.8 -p 18080:8080  jesshaw/sentinel-1.8.0

docker run -d --name mysentinel-1.7.2 -p 18080:8080  jesshaw/sentinel-1.7.2


## 以下是docker-compose的启动方法
```
docker-compose up --build -d
```

