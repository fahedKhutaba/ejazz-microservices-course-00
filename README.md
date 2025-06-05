git# ejazz-microservices-course-00

This project demonstrates Microservices Architecture by building a social network platform (similar to Twitter) using Spring Boot, Java 21, PostgreSQL, and Spring Cloud Config.

## Project Structure

```
ejazz-microservices-course-00/
├── common/             # Shared code and utilities
├── account-service/    # User account management microservice
├── post-service/       # Post/tweet management microservice
├── config-server/      # Spring Cloud Config Server (if present)
├── pom.xml             # Parent Maven POM
└── README.md
```

## Technologies Used

- **Java 21**
- **Spring Boot 3.4.5**
- **Spring Cloud Config**
- **PostgreSQL** (for persistent storage)
- **Lombok** (for boilerplate code reduction)
- **Springdoc OpenAPI** (for API documentation)
- **JaCoCo** (for code coverage)
- **Docker** (for containerization)

## Getting Started

### Prerequisites

- Java 21+
- Maven 3.8+
- Docker (for running PostgreSQL and building images)
- Git

### Configuration Management

- All service configurations are managed centrally using **Spring Cloud Config Server**.
- Config files are stored in a Git repository (see `config-server` setup).

### Database

- **PostgreSQL** is used for persistent storage.
- Update your `account-service` and `post-service` config in the config repository (e.g., `account-service-dev.yml`) with your PostgreSQL connection details.

### Running the Project

1. **Start PostgreSQL**  
   You can use Docker:
   ```bash
   docker run --name ejazz-postgres -e POSTGRES_DB=accountdb -e POSTGRES_USER=your_db_user -e POSTGRES_PASSWORD=your_db_password -p 5432:5432 -d postgres:16
   ```

2. **Start the Config Server**  
   (If you have a config-server module)
   ```bash
   cd config-server
   mvn spring-boot:run
   ```

3. **Build all services**
   ```bash
   mvn clean package
   ```

4. **Run a microservice**
   ```bash
   cd account-service
   mvn spring-boot:run
   ```
   Or run the JAR:
   ```bash
   java -jar target/account-service-0.0.1-SNAPSHOT.jar
   ```

5. **Build Docker images**
   ```bash
   cd account-service
   docker build -t account-service:latest .
   ```

## Module Descriptions

- **common**: Shared DTOs, exceptions, and utilities.
- **account-service**: Handles user registration, authentication, and profile management.
- **post-service**: Handles creating, retrieving, and managing posts/tweets.
- **config-server**: Centralized configuration management for all microservices.

## API Documentation

- Each service exposes OpenAPI docs at `/swagger-ui.html` (via Springdoc).

## Useful Commands

- **Run tests with coverage:**
  ```bash
  mvn clean test
  ```
- **View JaCoCo reports:**  
  Open `target/site/jacoco/index.html` in your browser.

## Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

---

**Project maintained by [your name/team].**
