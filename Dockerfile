FROM openjdk:11-jre-slim
WORKDIR /app
COPY build/libs/toshiro-shibakita-0.0.1-SNAPSHOT.jar /app/api.jar
EXPOSE 8080
CMD ["java", "-jar", "api.jar"]

