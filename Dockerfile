FROM maven:3.8.2-jdk-8
COPY ./target/tpAachat-1.0.jar tpAchat-1.0.jar
CMD ["java","-jar","tpAchat-1.0.jar"]

