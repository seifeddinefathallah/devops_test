FROM openjdk:8
EXPOSE 8089
COPY  target/tpachat.jar tpachat.jar
CMD ["java","-jar","/tpachat.jar"]