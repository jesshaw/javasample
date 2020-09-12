FROM openjdk:8-jre-alpine
MAINTAINER jes
WORKDIR /
ADD ./target/*.jar docker-deploy.jar
CMD ["java","-jar","docker-deploy.jar"]

