package com.ejazz.account_service.controller;

import com.ejazz.account_service.entity.Account;
import com.ejazz.account_service.repository.AccountRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts") // Ensure this matches your intended endpoint
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    // Get all accounts
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Create a new account
    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
        Account savedAccount = accountRepository.save(account);
        return ResponseEntity.ok(savedAccount);
    }
}
