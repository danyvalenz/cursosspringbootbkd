FROM maven:3.9.5-amazoncorretto-21 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ ./src
RUN mvn clean package -DskipTests -Dfile.encoding=UTF-8
FROM eclipse-temurin:21-jre-alpine
ARG JAR_FILE=target/cursosbkd-0.0.1-SNAPSHOT.jar
COPY --from=builder /app/${JAR_FILE} app.jar
ENV PORT 8080
ENTRYPOINT ["java", "-jar", "app.jar"]