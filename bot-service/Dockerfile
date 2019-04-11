FROM openjdk:11
ADD ./target/bot-service-0.0.1-SNAPSHOT.jar /usr/src/bot-service-0.0.1-SNAPSHOT.jar
ADD ./src/main/resources/data.csv /usr/src/data.csv
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "bot-service-0.0.1-SNAPSHOT.jar"]