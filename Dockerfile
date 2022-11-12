FROM openjdk:8
ADD target/tpachat.jar tpachat.jar
EXPOSE 8089
ENTRYPOINT [ "java", "-jar", "tpachat-1.0.jar" ]