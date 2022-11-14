FROM openjdk:8
EXPOSE 8089
ADD target/tpachat.jar tpachat.jar
CMD ["java","-jar","/tpachat.jar"]