# Java 21 base image
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

# Build using Maven wrapper
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["sh", "-c", "java -jar target/*.jar"]

