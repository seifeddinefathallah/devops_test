FROM openjdk:8
COPY ./target/tpachat.jar tpachat-1.0.jar
CMD ["java","-jar","tpachat-1.0.jar"]