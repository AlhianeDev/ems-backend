FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

COPY target/*.jar ems-backend.jar

ENTRYPOINT ["java","-jar","/ems-backend.jar"]

EXPOSE 8080
