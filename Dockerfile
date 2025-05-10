FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY /target/SubscriptionService-0.0.1-SNAPSHOT.jar /app/SubscriptionService-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "SubscriptionService-0.0.1-SNAPSHOT.jar"]