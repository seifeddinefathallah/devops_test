FROM maven:3.8.2-jdk-8
EXPOSE 8089
COPY /target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar"]