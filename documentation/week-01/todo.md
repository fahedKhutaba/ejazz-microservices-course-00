# Week 01 - To-Do List

This document outlines the tasks for improving the `account-service` and implementing best practices.

---

### Tasks:

- 🟥 **To Do**: Task not started.
- 🟨 **In Progress**: Task is currently being worked on.
- 🟩 **Completed**: Task is finished.

---

1. **Reformat the `Account` Data Model** 🟩
   Add more details to the `Account` entity, such as:

   | **Field Name**       | **Data Type**     | **Mandatory** | **Settings / Notes**                                                                 |
   |----------------------|------------------|---------------|--------------------------------------------------------------------------------------|
   | `id`                 | `BIGINT`         | Yes           | Primary Key, Auto-increment                                                         |
   | `account_number`     | `BIGINT`         | Yes           | Primary Key, generated automatically using UUID for security or decoupling as an external identifier |
   | `email`              | `VARCHAR(255)`   | Yes           | Unique, Not Null                                                                    |
   | `password`           | `VARCHAR(255)`   | Yes           | Hashed, Not Null                                                                    |
   | `first_name`         | `VARCHAR(100)`   | Yes           | Not Null, User's given name                                                         |
   | `family_name`        | `VARCHAR(100)`   | Yes           | Not Null, User's surname                                                            |
   | `birth_date`         | `DATE`           | No            | Optional, Must be a past date                                                       |
   | `phone_number`       | `VARCHAR(20)`    | No            | Optional, should follow a valid phone number format                                 |
   | `address`            | `VARCHAR(255)`   | No            | Optional, User's address                                                            |
   | `created_at`         | `TIMESTAMP`      | Yes           | Default: current timestamp, set on creation                                         |
   | `updated_at`         | `TIMESTAMP`      | Yes           | Automatically updated on modification                                               |

   - Update the `AccountDTO` to include these new fields.
   - Ensure proper validation annotations (e.g., `@NotBlank`, `@Size`, `@Pattern`) are added to the new fields.

---

2. **Global Exception Handling with `@ControllerAdvice`** 🟥
   - Add logic for a global exception handler using the `@ControllerAdvice` annotation.
   - Handle custom exceptions like `CustomerAlreadyExistException`.

---

3. **Error Handling and HTTP Status** 🟥
   - Implement proper error handling by returning meaningful HTTP status codes (e.g., `409 Conflict` for a resource that already exists).

---

4. **Avoiding `@Autowired` Annotation** 🟥
   - Use constructor-based dependency injection instead of field injection with `@Autowired`.

---

5. **Fetching Resources and Custom Exceptions** 🟥
   - Implement logic to fetch resources by `mobileNumber` or `username`.
   - If the resource does not exist, throw a custom exception like `CustomerNotExistException`.
   - Handle this exception globally using the `@ControllerAdvice` mechanism.

---

6. **Timeline or Metadata** 🟥
   - Track the progress of tasks with timestamps or metadata (e.g., `{start:2025-05-15T18:00:21}`).

---

7. **Implement Authentication Logic** 🟥
   - Add an endpoint to authenticate users by email and password.
   - Validate the provided credentials against the stored hashed password.
   - Return a success response (e.g., a token or session ID) if the credentials match.
   - Return an error response (e.g., `401 Unauthorized`) if the credentials do not match.

   **Summary**:
   - This task involves adding an authentication endpoint to the `account-service`.
   - Use a secure hashing algorithm (e.g., BCrypt) to validate passwords.
   - Ensure proper error handling and logging for failed authentication attempts.

---