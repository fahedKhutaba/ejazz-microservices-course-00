FROM eclipse-temurin:21-jre
VOLUME "/data" 
COPY target/account-service-0.0.1-SNAPSHOT.jar /app.jar
# Expose the port the app runs on
EXPOSE 8080
# The application's jar file
# Add the application's jar to the container   
ENTRYPOINT ["java","-jar","/app.jar"]