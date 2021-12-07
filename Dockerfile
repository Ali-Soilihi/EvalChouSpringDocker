FROM maven:3-openjdk-11-slim
COPY evalchou /app
RUN  cd /app && mvn -DskipTests clean package
ENTRYPOINT ["java","-jar","/app/target/EvalChou-0.0.1-SNAPSHOT.jar"]
