FROM java:8
ADD target/crud-application.jar crud-application.jar
EXPOSE 8009
ENTRYPOINT ["java" , "-jar" , "crud-application.jar"]