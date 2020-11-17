FROM openjdk:8-jdk-alpine
ADD target/crud-application.jar crud-application.jar
EXPOSE 8009
ENTRYPOINT ["java" , "-jar" , "crud-application.jar"]