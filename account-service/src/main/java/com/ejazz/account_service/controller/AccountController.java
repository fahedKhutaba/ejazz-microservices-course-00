package com.ejazz.account_service.controller;

import com.ejazz.account_service.dto.AccountDTO;
import com.ejazz.account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<AccountDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public AccountDTO getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @PostMapping
    public AccountDTO createAccount(@RequestBody AccountDTO accountDTO) {
        return accountService.saveAccount(accountDTO);
    }
}
