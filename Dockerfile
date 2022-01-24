FROM openjdk:13-jdk-alpine
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} restful-web-service.jar
ENTRYPOINT ["java","-jar","/restful-web-service.jar"]