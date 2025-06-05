## 🧭 Service Discovery with Eureka

In this session, we explored the role of **Eureka** as a service discovery server in a microservices architecture. Eureka enables services to find and communicate with each other dynamically, which is essential for scalability and resilience.

### Key Concepts Covered

- **Why Service Discovery?**
  - Eliminates the need for hardcoded service URLs.
  - Enables dynamic scaling and failover.
  - Simplifies inter-service communication in distributed systems.

- **Eureka Server Dependencies**
  - To set up a Eureka server, add the following dependencies to your `pom.xml`:
    ```xml
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-config</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    ```
  - The `spring-cloud-starter-config` dependency allows Eureka to fetch its configuration from the config server.

- **Most Important Configuration**
  - The main settings for Eureka server are:
    ```yaml
    server:
      port: 8070

    spring:
      application:
        name: eureka-service
      config:
        import: "optional:configserver:http://localhost:8888"

    eureka:
      instance:
        hostname: localhost
      client:
        register-with-eureka: false
        fetch-registry: false
        service-url:
          defaultZone: http://localhost:8070/eureka/
    ```
  - `register-with-eureka: false` and `fetch-registry: false` ensure the server does not try to register itself or fetch other registries (standalone mode).
  - `service-url.defaultZone` should point to the Eureka server's own endpoint.

- **Preservation Mode (Self-Preservation)**
  - **Preservation mode** is a safety feature in Eureka that helps prevent accidental removal of healthy instances during network issues.
  - When enabled (default), Eureka will stop expiring instances if too many heartbeats are missed, assuming a network partition rather than mass failure.
  - You can control this with:
    ```yaml
    eureka:
      server:
        enable-self-preservation: true
    ```
  - In development, you may set it to `false` for faster instance removal, but in production, it is recommended to keep it enabled.

- **Running Eureka Server**
  - Start the Eureka server:
    ```
    java -jar target/eureka-service-0.0.1-SNAPSHOT.jar
    ```
  - Access the Eureka dashboard at:  
    [http://localhost:8070/](http://localhost:8070/)

---

*Eureka provides dynamic service registration and discovery, making your microservices architecture robust, scalable, and easier to manage.*