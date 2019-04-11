FROM openjdk:11

ADD ./target/manual-answer-service-0.0.1-SNAPSHOT.jar /usr/src/manual-answer-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "manual-answer-service-0.0.1-SNAPSHOT.jar"]