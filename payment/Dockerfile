from eclipse-temurin:21-jdk-alpine as build

# WE DEFINE THE WORKING DIRECTORY
WORKDIR /app

# We only copy the files needed to build the application
COPY mvnw pom.xml ./
COPY .mvn .mvn

# We download the dependencies
RUN ./mvnw dependency:go-offline -B

# We copy the source code
COPY src ./src

# We compile and package the application
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=build /app/target/payment-0.0.1-SNAPSHOT.jar payment-service.jar

ENTRYPOINT ["java", "-jar", "payment-service.jar"]

