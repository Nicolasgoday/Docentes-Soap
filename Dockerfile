# For Java 8, try this
FROM openjdk:8-jdk-alpine


# Refer to Maven build -> finalName
ARG JAR_FILE=target/docentesoap-v0.0.1.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080
# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]