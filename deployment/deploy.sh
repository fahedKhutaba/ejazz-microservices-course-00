#!/bin/bash

# Set your Docker Hub username
DOCKER_USER=your-dockerhub-user

# List of services (adjust as needed)
SERVICES=("config-server" "eureka-service" "account-service" "post-service")

# 1. Build JARs
for SERVICE in "${SERVICES[@]}"; do
  echo "Building $SERVICE..."
  (cd ../$SERVICE && mvn clean package -DskipTests)
done

# 2. Build Docker images and push to Docker Hub
for SERVICE in "${SERVICES[@]}"; do
  echo "Building Docker image for $SERVICE..."
  (cd ../$SERVICE && docker build -t $DOCKER_USER/$SERVICE:latest .)
  echo "Pushing $SERVICE image to Docker Hub..."
  docker push $DOCKER_USER/$SERVICE:latest
done

# 3. Start services with Docker Compose
echo "Starting services with docker-compose..."
docker-compose up --build
