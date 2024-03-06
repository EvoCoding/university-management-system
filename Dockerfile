FROM gradle:jdk11 as builder
COPY . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:17-jre-slim

COPY --from=builder /home/gradle/src/build/libs/*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
EXPOSE 8090
