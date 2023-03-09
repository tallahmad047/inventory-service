FROM openjdk:17-jdk-alpine
ADD target/*.jar inventory-service.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/inventory-service.jar8"]
VOLUME /main-app
LABEL key="groupe3aw"