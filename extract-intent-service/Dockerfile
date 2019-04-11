FROM openjdk:11
ADD ./target/extract-intent-service-0.0.1-SNAPSHOT.jar /usr/src/extract-intent-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "extract-intent-service-0.0.1-SNAPSHOT.jar"]