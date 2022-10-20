FROM openjdk:17
EXPOSE 8090
COPY /target/*.jar /Users/alberto.gdepablos/lib/spring.jar
ENTRYPOINT ["java","-jar","/Users/alberto.gdepablos/lib/spring.jar"]
