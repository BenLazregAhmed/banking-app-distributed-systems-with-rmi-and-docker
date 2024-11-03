FROM openjdk:21-rc-oraclelinux8
VOLUME /tmp
COPY target/bank-client-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]