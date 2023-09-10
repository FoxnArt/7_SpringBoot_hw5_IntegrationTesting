FROM openjdk:17-alpine
EXPOSE 8081
ADD target/_7_SpringBoot_hw1_Conditional_application-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java","-jar","/myapp.jar"]