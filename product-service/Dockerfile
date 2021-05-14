FROM openjdk:8-jdk-alpine
EXPOSE 9090
ARG JAR_FILE=target/product-service.jar
ADD ${JAR_FILE} app.jar
CMD ["java", "-jar", "/app.jar"]