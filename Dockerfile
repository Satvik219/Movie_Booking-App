FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

# 🔥 Give execute permission to mvnw
RUN chmod +x mvnw

# Build the app
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["sh", "-c", "java -jar target/*.jar"]
