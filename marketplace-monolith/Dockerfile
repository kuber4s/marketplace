FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder
WORKDIR /build
COPY pom.xml .
COPY checkstyle.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /build/target/marketplace-monolith-*.jar /app/marketplace-monolith.jar
EXPOSE 8080
ENV SPRING_PROFILES_ACTIVE=docker
USER 1000
CMD ["java", "-jar", "/app/marketplace-monolith.jar"]