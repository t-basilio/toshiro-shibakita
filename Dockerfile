FROM alpine:3.14

RUN apk add --no-cache openjdk21-jre

WORKDIR /app

COPY build/libs/toshiro-shibakita-0.0.1-SNAPSHOT.jar /app/api.jar

EXPOSE 8080

CMD ["java", "-jar", "api.jar"]