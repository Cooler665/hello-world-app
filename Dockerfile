FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/helloworld-1.0-SNAPSHOT.jar /app/helloworld.jar

COPY ./src/main/resources/application.properties /app/application.properties
EXPOSE 443

CMD ["java", "-jar", "/app/helloworld.jar"]





