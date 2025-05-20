
# Post Service

A Spring Boot service for managing posts, built with Java 21 and Spring Boot 3.4.5.

---

## Project Setup

### 1. **Project Configuration**
Use [Spring Initializer](https://start.spring.io/) to generate the project with the following configuration:
- **Project**: Maven
- **Language**: Java
- **Spring Boot Version**: 3.4.5
- **Packaging**: Jar
- **Java Version**: 21
- **Group**: `com.ejazz`
- **Artifact**: `post-service`
- **Dependencies**:
  - Spring Web
  - H2 Database
  - Spring Data JPA
  - Spring Boot Actuator
  - Spring Boot DevTools
  - Lombok
  - Spring Boot Starter Validation

---

## Dependencies

Ensure the `pom.xml` includes the following dependencies:

```xml
<dependencies>
    <!-- Spring Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- H2 Database -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Spring Boot Actuator -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>

    <!-- Spring Boot DevTools -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <scope>provided</scope>
    </dependency>

    <!-- Spring Boot Starter Validation -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>

    <!-- Test Dependencies -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---

## Configuration

### `application.properties`
Configure the H2 database and other settings in `src/main/resources/application.properties`:

```properties
# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:postdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true

# Actuator Configuration
management.endpoints.web.exposure.include=*

# DevTools Configuration
spring.devtools.restart.enabled=true
```

---

## Code Structure

### 1. **Main Application Class**
Create the main application class in `src/main/java/com/ejazz/post_service/PostServiceApplication.java`:

```java
package com.ejazz.post_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PostServiceApplication.class, args);
    }
}
```

---

### 2. **Entity Class**
Create the `Post` entity in `src/main/java/com/ejazz/post_service/entity/Post.java`:

```java
package com.ejazz.post_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @NotBlank(message = "Content is required")
    private String content;
}
```

---

### 3. **Repository Interface**
Create the `PostRepository` interface in `src/main/java/com/ejazz/post_service/repository/PostRepository.java`:

```java
package com.ejazz.post_service.repository;

import com.ejazz.post_service.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
```

---

### 4. **Controller Class**
Create the `PostController` class in `src/main/java/com/ejazz/post_service/controller/PostController.java`:

```java
package com.ejazz.post_service.controller;

import com.ejazz.post_service.entity.Post;
import com.ejazz.post_service.repository.PostRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    // Get all posts
    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Create a new post
    @PostMapping
    public ResponseEntity<Post> createPost(@Valid @RequestBody Post post) {
        Post savedPost = postRepository.save(post);
        return ResponseEntity.ok(savedPost);
    }
}
```

---

## Running the Application

### 1. **Start the Application**
Navigate to the project directory and run the application:
```bash
mvn spring-boot:run
```

### 2. **Access the H2 Console**
Open the H2 console in your browser:
```
http://localhost:8080/h2-console
```
- **JDBC URL**: `jdbc:h2:mem:postdb`
- **Username**: `sa`
- **Password**: (leave blank)

---

## Testing the API

### 1. **Create a Post**
Send a `POST` request to create a new post.

- **URL**: `http://localhost:8080/api/posts`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "title": "My First Post",
    "content": "This is the content of my first post."
  }
  ```

- **Response**:
  ```json
  {
    "id": 1,
    "title": "My First Post",
    "content": "This is the content of my first post."
  }
  ```

---

### 2. **Get All Posts**
Send a `GET` request to retrieve all posts.

- **URL**: `http://localhost:8080/api/posts`
- **Method**: `GET`

- **Response**:
  ```json
  [
    {
      "id": 1,
      "title": "My First Post",
      "content": "This is the content of my first post."
    }
  ]
  ```

---

## Project Structure

```
src/main/java/com/ejazz/post_service/
├── PostServiceApplication.java  // Main application class
├── controller/
│   └── PostController.java      // REST controller
├── entity/
│   └── Post.java                // JPA entity
└── repository/
    └── PostRepository.java      // JPA repository
```

---

Let me know if you need further assistance!

Similar code found with 3 license types