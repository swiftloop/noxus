FROM openjdk:8-alpine

WORKDIR /workspace/app



COPY  app.jar app.jar

VOLUME /workspace/app

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
