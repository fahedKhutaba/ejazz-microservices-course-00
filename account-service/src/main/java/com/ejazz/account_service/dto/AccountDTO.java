// filepath: c:\Users\fahed-kh\workspace\ejazz-microservices-course-00\account-service\src\main\java\com\ejazz\account_service\dto\AccountDTO.java
package com.ejazz.account_service.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data @Getter @Setter
public class AccountDTO {

    private String accountNumber; // No validation since it will be generated

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "First name is required")
    @Size(max = 100, message = "First name must not exceed 100 characters")
    private String firstName;

    @NotBlank(message = "Family name is required")
    @Size(max = 100, message = "Family name must not exceed 100 characters")
    private String familyName;

    @Past(message = "Birth date must be a past date")
    private LocalDate birthDate;

    @Pattern(regexp = "^\\+?[0-9]{7,20}$", message = "Phone number must be valid")
    private String phoneNumber;

    @Size(max = 255, message = "Address must not exceed 255 characters")
    private String address;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}