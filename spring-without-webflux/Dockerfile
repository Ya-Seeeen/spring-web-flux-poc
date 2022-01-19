#FROM adoptopenjdk/openjdk11:alpine-jre
#ADD target/RestPatient-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:11
EXPOSE 9081
ADD target/spring-without-webflux-0.0.1-SNAPSHOT.jar app.jar

RUN mkdir -p ~/.aws

COPY /config ~/.aws/
COPY /credentials ~/.aws/

ENTRYPOINT ["java", "-jar", "/app.jar"]