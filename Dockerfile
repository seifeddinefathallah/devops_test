FROM maven:3.8.2-jdk-8
WORKDIR /spring-app
EXPOSE 8089
COPY . .
RUN mvn clean install -Dmaven.test.skip=true
CMD mvn  spring-boot:run