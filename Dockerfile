FROM openjdk:8-jdk
EXPOSE 8089
COPY ./target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar"]