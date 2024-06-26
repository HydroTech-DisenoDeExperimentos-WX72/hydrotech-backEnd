#
# Build stage
#
FROM maven:3.9.6 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:21-jdk-slim
COPY --from=build /target/backend-0.0.1-SNAPSHOT.jar backend.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","backend.jar"]