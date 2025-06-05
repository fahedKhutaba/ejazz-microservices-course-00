@echo off
set DOCKER_USER=your-dockerhub-user

REM List your services here
set SERVICES=config-server eureka-service account-service post-service feed-service

REM 1. Build JARs
for %%S in (%SERVICES%) do (
    echo Building %%S...
    cd ..\%%S
    call mvn clean package -DskipTests
    cd ..\deployment
)

REM 2. Build Docker images and push to Docker Hub
for %%S in (%SERVICES%) do (
    echo Building Docker image for %%S...
    cd ..\%%S
    docker build -t %DOCKER_USER%/%%S:latest .
    echo Pushing %%S image to Docker Hub...
    docker push %DOCKER_USER%/%%S:latest
    cd ..\deployment
)

REM 3. Start services with Docker Compose
echo Starting services with docker-compose...
docker-compose up --build