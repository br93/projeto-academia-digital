FROM openjdk:11-jre-slim-buster
VOLUME /tmp
COPY target/academia-digital-0.0.1-SNAPSHOT.jar AcademiaDigital.jar
ENTRYPOINT ["java", "-jar", "AcademiaDigital.jar"]