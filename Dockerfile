FROM maven:3.8.2-jdk-8
COPY ./target/tpaachat-1.0.jar tpachat-1.0.jar
CMD ["java","-jar","tpachat-1.0.jar"]

