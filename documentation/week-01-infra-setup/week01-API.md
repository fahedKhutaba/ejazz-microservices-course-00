# API Documentation for Account and Post Services

This document provides details about the APIs for the **Account Service** and **Post Service**. You can use these APIs to manage accounts and posts in the system.

---

## Account Service

### Base URL
```
http://localhost:8080/api/accounts
```

### How to Run the Service
To start the Account Service, navigate to the service directory and run the following command:
```bash
cd account-service
mvn spring-boot:run
```

### Endpoints

#### 1. Get All Accounts
- **URL**: `/`
- **Method**: `GET`
- **Description**: Retrieves a list of all accounts.
- **Sample Request**:
  ```bash
  GET http://localhost:8080/api/accounts
  ```
- **Sample Response**:
  ```json
  [
      {
          "id": 1,
          "name": "John Doe",
          "email": "john.doe@example.com"
      },
      {
          "id": 2,
          "name": "Jane Smith",
          "email": "jane.smith@example.com"
      }
  ]
  ```

#### 2. Get Account by ID
- **URL**: `/{id}`
- **Method**: `GET`
- **Description**: Retrieves details of a specific account by ID.
- **Sample Request**:
  ```bash
  GET http://localhost:8080/api/accounts/1
  ```
- **Sample Response**:
  ```json
  {
      "id": 1,
      "name": "John Doe",
      "email": "john.doe@example.com"
  }
  ```

#### 3. Create a New Account
- **URL**: `/`
- **Method**: `POST`
- **Description**: Creates a new account.
- **Request Body**:
  ```json
  {
      "name": "Alice Johnson",
      "email": "alice.johnson@example.com"
  }
  ```
- **Sample Request**:
  ```bash
  POST http://localhost:8080/api/accounts
  Content-Type: application/json
  ```
- **Sample Response**:
  ```json
  {
      "id": 3,
      "name": "Alice Johnson",
      "email": "alice.johnson@example.com"
  }
  ```

---

## Post Service

### Base URL
```
http://localhost:8081/api/posts
```

### How to Run the Service
To start the Post Service, navigate to the service directory and run the following command:
```bash
cd post-service
mvn spring-boot:run
```

### Endpoints

#### 1. Get All Posts
- **URL**: `/`
- **Method**: `GET`
- **Description**: Retrieves a list of all posts.
- **Sample Request**:
  ```bash
  GET http://localhost:8081/api/posts
  ```
- **Sample Response**:
  ```json
  [
      {
          "id": 1,
          "title": "First Post",
          "content": "This is the content of the first post.",
          "authorId": 1
      },
      {
          "id": 2,
          "title": "Second Post",
          "content": "This is the content of the second post.",
          "authorId": 2
      }
  ]
  ```

#### 2. Get Post by ID
- **URL**: `/{id}`
- **Method**: `GET`
- **Description**: Retrieves details of a specific post by ID.
- **Sample Request**:
  ```bash
  GET http://localhost:8081/api/posts/1
  ```
- **Sample Response**:
  ```json
  {
      "id": 1,
      "title": "First Post",
      "content": "This is the content of the first post.",
      "authorId": 1
  }
  ```

#### 3. Create a New Post
- **URL**: `/`
- **Method**: `POST`
- **Description**: Creates a new post.
- **Request Body**:
  ```json
  {
      "title": "New Post",
      "content": "This is the content of the new post.",
      "authorId": 1
  }
  ```
- **Sample Request**:
  ```bash
  POST http://localhost:8081/api/posts
  Content-Type: application/json
  ```
- **Sample Response**:
  ```json
  {
      "id": 3,
      "title": "New Post",
      "content": "This is the content of the new post.",
      "authorId": 1
  }
  ```

---

## Notes
- you can use the h2dosel http://localhost:8080/h2-console to query the db
- Replace `localhost` with the actual host if deployed on a server.
- Use tools like Postman or cURL to test these APIs.
- Ensure the services are running on their respective ports (`8080` for Account Service and `8081` for Post Service).