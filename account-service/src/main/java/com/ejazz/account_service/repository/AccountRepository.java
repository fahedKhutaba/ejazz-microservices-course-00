package com.ejazz.account_service.repository;

import com.ejazz.account_service.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // Custom query methods can be added here if needed
}