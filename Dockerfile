FROM openjdk:17-jdk-alpine

ADD "./target/videojuegos-0.0.2.jar" "app.jar"
EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]