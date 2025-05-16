// filepath: c:\Users\fahed-kh\workspace\ejazz-microservices-course-00\account-service\src\main\java\com\ejazz\account_service\dto\AccountDTO.java
package com.ejazz.account_service.dto;

public class AccountDTO {
    private Long id;
    private String name;
    private String email;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}