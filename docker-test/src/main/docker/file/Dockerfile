FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD spring-boot-docker-1.0.jar app.jar

# 正常使用 java -jar  就可以启动服务
# 这里 的-Djava.security.egd=file:/dev/./urandom 表示在tomcat + docker 的时候 启动比较慢
#
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
