@echo off

REM List your services and their folders here
set SERVICES=config-server eureka-service account-service post-service feed-service

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
    IF NOT EXIST Dockerfile (
        echo ERROR: Dockerfile not found in %%S!
        cd ..\deployment
        exit /b 1
    )
    IF NOT EXIST target\*.jar (
        echo ERROR: JAR file not found in %%S\target!
        cd ..\deployment
        exit /b 1
    )
    docker build -t %%S:latest .
    IF %ERRORLEVEL% NEQ 0 (
        echo ERROR: Docker build failed for %%S!
        cd ..\deployment
        exit /b 1
    )
    cd ..\deployment
)

REM 3. Start services with Docker Compose
echo Starting services with docker-compose...
docker-compose up --build