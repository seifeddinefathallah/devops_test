FROM openjdk:8
WORKDIR /spring-app
ARG JAR_FILE
COPY ${JAR_FILE} tpachat.jar
EXPOSE 8089
RUN mvn clean install -Dmaven.test.skip=true
CMD mvn  spring-boot:run
ENTRYPOINT [ "java", "-jar", "tpachat-1.0.jar" ]
