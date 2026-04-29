FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

# 🔥 Install unzip (IMPORTANT FIX)
RUN apt-get update && apt-get install -y unzip

RUN chmod +x mvnw
RUN ./mvnw clean install -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/*.jar"]