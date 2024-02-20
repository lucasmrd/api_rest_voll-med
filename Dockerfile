FROM openjdk

WORKDIR /app

COPY target/api2-0.0.1-SNAPSHOT.jar /app/api2.jar

ENTRYPOINT ["java", "-jar", "api2.jar"]