package com.ejazz.account_service.repository;

import com.ejazz.account_service.entity.Account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
     Optional<Account> findByEmail(String email);
}