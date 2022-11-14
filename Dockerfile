FROM maven:3.8.2-jdk-8
WORKDIR /spring-app
EXPOSE 8089
COPY  . tpachat.jar
RUN mvn clean install
CMD ["java","-jar","/tpachat.jar"]mvn spring-boot:run