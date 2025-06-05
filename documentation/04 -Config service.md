## ⚙️ Centralized Configuration with Config Service

In this session, we explored the importance of centralized configuration management in a microservices architecture. By using a centralized configuration repository, we can easily manage and version configuration files for multiple services and environments (profiles), such as `dev`, `test`, and `prod`.

### Key Concepts Covered

- **Why Centralized Configuration?**
  - Simplifies configuration management across services.
  - Enables profile-based configuration (e.g., `service-name-dev.yml`).
  - Supports dynamic updates and version control using Git.

- **Configuration File Structure**
  - Configuration files are named using the pattern:  
    `servicename-profile.yml`  
    Example: `account-service-dev.yml`

- **Spring Cloud Config Server**
  - We reviewed the structure of the config-server service.
  - Added the `spring-cloud-config-server` dependency.
  - Configured the config server to use a remote Git repository for storing configuration files.

- **Connecting Services to Config Server**
  - Added the `spring-cloud-starter-config` dependency to the `account-service`.
  - This enables the service to fetch its configuration from the config server at startup.

- **Actuator Health Endpoint**
  - Discovered the actuator health API at:  
    [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)
  - Used to verify the health and connectivity of the service.

- **Running with a Profile**
  - Ran the account service with the `dev` profile to load the appropriate configuration:  
    ```
    java -jar target/account-service-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
    ```

---

*Centralized configuration with Spring Cloud Config Server enables scalable, maintainable, and environment-specific configuration management for your microservices ecosystem.*