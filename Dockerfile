FROM maven:3.8.6-jdk-8
 ARG DEPENDENCY=target
COPY --chown=1001 ${DEPENDENCY}/tpachat-1.0.jar tpachat-1.0.jar
CMD ["java","-jar","tpachat-1.0.jar"]