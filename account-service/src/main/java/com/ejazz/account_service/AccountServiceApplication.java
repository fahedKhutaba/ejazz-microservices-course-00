package com.ejazz.account_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Account Service API",
        version = "1.0.0",
        description = "API documentation for the Account Service, which manages user accounts.",
        contact = @Contact(
            name = "Fahed Khutaba",
            email = "fahed.kh@example.com",
            url = "https://www.ejazz.com"
        ),
        license = @License(
            name = "Apache License 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0"
        )
    )
)
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
}
