package com.ejazz.account_service.service;

import com.ejazz.account_service.dto.AccountDTO;
import com.ejazz.account_service.entity.Account;
import com.ejazz.account_service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Convert Account entity to AccountDTO
    private AccountDTO convertToDTO(Account account) {
        AccountDTO dto = new AccountDTO();
        dto.setId(account.getId());
        dto.setName(account.getUsername());
        dto.setEmail(account.getEmail());
        return dto;
    }

    // Convert AccountDTO to Account entity
    private Account convertToEntity(AccountDTO dto) {
        Account account = new Account();
        account.setId(dto.getId());
        account.setUsername(dto.getName());
        account.setEmail(dto.getEmail());
        account.setPassword("securepassword");
        return account;
    }

    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AccountDTO getAccountById(Long id) {
        return accountRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public AccountDTO saveAccount(AccountDTO accountDTO) {
        Account account = convertToEntity(accountDTO);
        Account savedAccount = accountRepository.save(account);
        return convertToDTO(savedAccount);
    }
}