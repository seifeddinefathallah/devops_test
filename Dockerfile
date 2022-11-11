FROM maven:3.8.2-jdk-8
EXPOSE 8089
ADD ./target/maven-status/tpachatproject-1.0.jar tpachatproject-1.0.jar
ENTRYPOINT ["java","-jar","tpachatproject-1.0.jar"]