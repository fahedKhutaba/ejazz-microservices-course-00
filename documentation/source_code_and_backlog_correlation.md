If you are using **GitHub Projects** (or GitLab Projects/Issues), you can correlate your source code and backlog using these approaches:

---

## 1. **Link Commits and Pull Requests to Issues**

- **Reference issue numbers in commit messages and PRs:**
  - Example commit message:  
    ```
    Add email validation to AccountDTO. Fixes #42
    ```
  - Example PR description:  
    ```
    Closes #42
    ```
- This will automatically link the commit/PR to the issue in GitHub Projects and show the relationship in both places.

---

## 2. **Branch Naming Conventions**

- Name branches after the issue or project task:
  - Example:  
    ```
    feature/42-email-validation
    ```
- This makes it easy to see which branch relates to which backlog item.

---

## 3. **Use GitHub Projects Boards**

- Create a **Project Board** and add issues (backlog items) as cards.
- Move issues/cards through columns (To Do, In Progress, Done) as you work.
- Link PRs and commits to issues/cards for traceability.

---

## 4. **Automatic Linking**

- When you mention an issue number in a commit or PR, GitHub will show the link in the issue’s timeline and in the PR.
- Closing keywords (`closes #42`, `fixes #42`) will automatically close the issue when the PR is merged.

---

## 5. **Project Automation**

- Use GitHub Projects automation to move issues/cards when PRs are opened, merged, or closed.

---

## 6. **Code Comments (Optional)**

- For major features, you can add a comment in the code referencing the issue:
  ```java
  // See GitHub Issue #42 for context
  ```

---

### **Summary Table**

| Action                        | Example/How-To                                  |
|-------------------------------|-------------------------------------------------|
| Commit message                | `git commit -m "Fixes #42: Add email validation"`|
| PR description                | `Closes #42`                                    |
| Branch name                   | `feature/42-email-validation`                   |
| Project board                 | Add issues/cards, move as you progress          |
| Code comment (optional)       | `// See Issue #42`                              |

---

**This workflow is standard for managing projects with GitHub Projects and ensures strong traceability between your backlog and your code.**

Let me know if you want a sample workflow or automation setup!---

### **Summary Table**

| Action                        | Example/How-To                                  |
|-------------------------------|-------------------------------------------------|
| Commit message                | `git commit -m "Fixes #42: Add email validation"`|
| PR description                | `Closes #42`                                    |
| Branch name                   | `feature/42-email-validation`                   |
| Project board                 | Add issues/cards, move as you progress          |
| Code comment (optional)       | `// See Issue #42`                              |

---

**This workflow is standard for managing projects with GitHub Projects and ensures strong traceability between your backlog and your code.**

Let me know if you want a sample workflow or automation setup!