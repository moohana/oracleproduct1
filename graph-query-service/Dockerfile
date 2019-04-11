FROM openjdk:11

ADD ./target/graph-query-service-0.0.1-SNAPSHOT.jar /usr/src/graph-query-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "graph-query-service-0.0.1-SNAPSHOT.jar"]