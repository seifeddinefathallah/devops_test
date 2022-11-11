FROM maven:3.8.2-jdk-8

WORKDIR /spring-app
COPY ./target/tpachat-1.0.jar tpachat-1.0.jar
CMD ["java","-jar","tpachat-1.0.jar"]
