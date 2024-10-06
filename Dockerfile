FROM gradle:jdk21 AS builder

WORKDIR /app

COPY build.gradle settings.gradle ./
COPY src ./src

RUN gradle build --no-daemon

FROM openjdk:21-jdk

WORKDIR /app

COPY --from=builder /app/build/libs/luxmed-interview-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]