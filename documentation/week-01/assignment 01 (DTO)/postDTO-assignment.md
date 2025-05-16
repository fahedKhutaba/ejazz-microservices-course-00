Here’s a clear and professional version of the assignment you can give to the new developer:

---

### 📝 **Development Assignment: Implementing DTO Design Pattern in `post-service`**

**Objective:**  
Refactor the `post-service` module to adopt the **DTO (Data Transfer Object) design pattern** for improved separation of concerns and maintainability.

---
### 📌 **Deliverables**
- Updated `post-service` module with:
  - DTO and service layers implemented.
  - Repository access abstracted through the service layer.
  - Proper mapping between DTOs and POJOs.
- A pull request from `ejazz-student` to `week01`.

---

### ✅ **Tasks**

1. **Branch Setup**
   - Use your working branch: `ejazz-student`.
   - Sync your branch with the latest changes from `week01`.
   - After completing the task, submit your changes to the `week01` branch via a pull request.

2. **Project Structure**
   - Create two new packages:
     - `dto` – for Data Transfer Objects.
     - `service` – for business logic and repository interaction.

3. **DTO Implementation**
   - Define appropriate DTO classes in the `dto` package to represent the data exchanged between the controller and service layers.
   - Ensure DTOs do not expose internal entity (POJO) structures directly.

4. **Service Layer**
   - Move all repository interactions into the `service` package.
   - Implement mapping logic between DTOs and POJOs using a mapping mechanism (e.g., manual mapping or a library like MapStruct or ModelMapper).
   - Ensure the controller communicates only with the service layer using DTOs.

5. **Code Quality**
   - Follow clean code principles.
   - Add meaningful comments and JavaDoc where necessary.
   - Ensure the code is well-tested and compiles without errors.

---
