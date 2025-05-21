Here’s a clear and structured task definition for updating the `Account` data model:

---

### 🛠️ **Task: Update Account Data Model**

**Objective:**  
Enhance the `Account` entity by adding new fields to support additional user profile information.

---
### 📌 **Deliverables**
- Updated `Account` entity class.
- Updated database schema or migration script.
- Updated DTOs and mapping logic (if applicable).
- Verified functionality through tests.

---

### ✅ **Tasks**

0. **Branch Setup**  (skip if you did that fro task postDto)
   - Use your working branch: `ejazz-student`.
   - Sync your branch with the latest changes from `week01`.
   - After completing the task, submit your changes to the `week01` branch via a pull request.

1. **Update the Account Table**
   - Modify the `Account` entity class to include the following new fields:
   Here’s a detailed specification for the updated `Account` table, including field names, data types, whether they are mandatory, and additional settings:

---

### 📋 **Account Table Structure**

| **Field Name**       | **Data Type**     | **Mandatory** | **Settings / Notes**                                                                 |
|----------------------|------------------|---------------|--------------------------------------------------------------------------------------|
| `id`                 | `BIGINT`         | Yes           | Primary Key, Auto-increment                                                         |
| `email`              | `VARCHAR(255)`   | Yes           | Unique, Not Null                                                                    |
| `password`           | `VARCHAR(255)`   | Yes           | Hashed, Not Null                                                                    |
| `first_name`         | `VARCHAR(100)`   | Yes           | Not Null, User's given name                                                         |
| `family_name`        | `VARCHAR(100)`   | Yes           | Not Null, User's surname                                                            |
| `birth_date`         | `DATE`           | No            | Optional, Must be a past date                                                       |
| `registration_date`  | `TIMESTAMP`      | Yes           | Default: current timestamp, set on creation                                         |
| `update_date`        | `TIMESTAMP`      | Yes           | Automatically updated on modification                                               |
| `phone_number`       | `VARCHAR(20)`    | No            | Optional, should follow a valid phone number format                                 |
| `created_at`         | `TIMESTAMP`      | Yes           | Default: current timestamp, set on creation                                         |
| `updated_at`         | `TIMESTAMP`      | Yes           | Automatically updated on modification                                               |

---

### ⚙️ **Hints**

- **Timestamps**: Use `@CreationTimestamp` and `@UpdateTimestamp` (if using Hibernate) for `registration_date`, `created_at`, and `update_date`.
- **Validation**:
  - `first_name` and `family_name`: Use `@NotBlank`, `@Size(max = 100)`
  - `birth_date`: Use `@Past`
  - `phone_number`: Use regex validation for format (e.g., `^\+?[0-9]{7,15}$`)


2. **Database Schema Update**
   - Update the corresponding database schema (e.g., using JPA annotations or SQL migration script) to reflect the new fields in the `account` table.

3. **Validation & Constraints**
   - Add appropriate validation annotations (e.g., `@NotNull`, `@Size`, `@Past`) where applicable.
   - Ensure `registrationDate` and `updateDate` are automatically managed (e.g., using `@PrePersist` and `@PreUpdate` if using JPA).

4. **DTO and Mapping**
   - If using DTOs, update or create corresponding DTO classes to include the new fields.
   - Ensure mapping between DTO and entity is updated accordingly.

5. **Testing**
   - Update or create unit and integration tests to verify the new fields are correctly handled in CRUD operations.

---


