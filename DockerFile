#From <image>
FROM openjdk:11

#Temp folder to run the APP
VOLUME /tmp

#Provide port number to run the application
EXPOSE 6060

#adding the jar file location to mapping name/alias name
ADD target/tourist-service.jar tourist-service.jar

#Jar Execution command
ENTRYPOINT ["java","-jar","/tourist-service.jar"]