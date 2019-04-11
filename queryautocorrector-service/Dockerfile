FROM openjdk:11
ADD ./target/queryautocorrector-service-0.0.1-SNAPSHOT.jar /usr/src/queryautocorrector-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "queryautocorrector-service-0.0.1-SNAPSHOT.jar"]