# Use a lightweight JDK image
FROM eclipse-temurin:21-jre-alpine

# Set workdir
WORKDIR /app

# Copy the jar (replace with your actual jar name)
COPY target/*.jar app.jar

# Expose the port (replace with your service's port)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]