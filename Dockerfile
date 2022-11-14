FROM maven:3.8.2-jdk-8
WORKDIR /var/lib/jenkins/workspace/TpAcharPip@2 
ARG JAR_FILE
COPY ${JAR_FILE} tpachat-1.0.jar
CMD ["java","-jar","tpachat-1.0.jar"]
