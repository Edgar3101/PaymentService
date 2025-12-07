from eclipse-temurin:21-jdk-alpine as build

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=build /app/target/payment-0.0.1-SNAPSHOT.jar payment-service.jar

ENTRYPOINT ["java", "-jar", "payment-service.jar"]

