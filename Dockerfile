FROM openjdk:21-jdk
LABEL github.com="Tamal2017"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]