@echo off

REM List your services and their folders here
set SERVICES=config-server eureka-service account-service post-service feed-service gateway-server

REM 1. Build JARs
for %%S in (%SERVICES%) do (
    echo Building %%S...
    cd ..\%%S
    call mvn clean package -DskipTests
    cd ..\deployment
)

REM 2. Build Docker images with explicit name:tag
for %%S in (%SERVICES%) do (
    echo Building Docker image for %%S...
    cd ..\%%S
    docker build -t %%S:latest .
    cd ..\deployment
)

REM 3. Start services with Docker Compose
echo Starting services with docker-compose...
docker-compose up --build