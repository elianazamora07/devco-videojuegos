FROM openjdk:17-jdk-alpine
ADD "./target/videojuegos-0.0.2.jar" "app.jar"
ENTRYPOINT ["java","-jar","app.jar"]