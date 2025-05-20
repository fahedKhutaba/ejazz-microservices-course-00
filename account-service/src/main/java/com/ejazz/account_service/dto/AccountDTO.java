// filepath: c:\Users\fahed-kh\workspace\ejazz-microservices-course-00\account-service\src\main\java\com\ejazz\account_service\dto\AccountDTO.java
package com.ejazz.account_service.dto;

public class AccountDTO {
    private String firstName;
    private String familyName;
    private java.time.LocalDate birthDate;
    private String email;
    private String password;

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public java.time.LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(java.time.LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}