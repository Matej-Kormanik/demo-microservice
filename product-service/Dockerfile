FROM openjdk:8-jdk-alpine
ADD target/product-service.jar app.jar
CMD ["java","-Dspring.profiles.active=docker","-jar", "/app.jar"]