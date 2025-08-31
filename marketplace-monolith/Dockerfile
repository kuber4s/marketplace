FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn clean package

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /build/target/marketplace-monolith-0.0.1-SNAPSHOT.jar /app/marketplace-monolith.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/marketplace-monolith.jar"]