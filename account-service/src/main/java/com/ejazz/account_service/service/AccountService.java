package com.ejazz.account_service.service;

import com.ejazz.account_service.dto.AccountDTO;
import com.ejazz.account_service.dto.CreateAccountDTO;
import com.ejazz.account_service.entity.Account;
import com.ejazz.account_service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Convert Account entity to AccountDTO
    public AccountDTO convertToDTO(Account account) {
        AccountDTO dto = new AccountDTO();
        dto.setAccountNumber(account.getAccountNumber());
        dto.setEmail(account.getEmail());
        dto.setFirstName(account.getFirstName());
        dto.setFamilyName(account.getFamilyName());
        dto.setBirthDate(account.getBirthDate());
        dto.setPhoneNumber(account.getPhoneNumber());
        dto.setAddress(account.getAddress());
        dto.setCreatedAt(account.getCreatedAt());
        dto.setUpdatedAt(account.getUpdatedAt());
        return dto;
    }

    // Convert AccountDTO to Account entity
    public Account convertToEntity(AccountDTO dto) {
        Account account = new Account();
        account.setAccountNumber(dto.getAccountNumber());
        account.setEmail(dto.getEmail());
        account.setFirstName(dto.getFirstName());
        account.setFamilyName(dto.getFamilyName());
        account.setBirthDate(dto.getBirthDate());
        account.setPhoneNumber(dto.getPhoneNumber());
        account.setAddress(dto.getAddress());
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

    public AccountDTO saveAccount(CreateAccountDTO createAccountDTO) {
        Account account = new Account();

        // Generate a unique account number
        account.setAccountNumber(generateAccountNumber());

        account.setEmail(createAccountDTO.getEmail());
        account.setPassword(hashPassword(createAccountDTO.getPassword())); // Hash the password
        account.setFirstName(createAccountDTO.getFirstName());
        account.setFamilyName(createAccountDTO.getFamilyName());
        account.setBirthDate(createAccountDTO.getBirthDate());
        account.setPhoneNumber(createAccountDTO.getPhoneNumber());
        account.setAddress(createAccountDTO.getAddress());

        Account savedAccount = accountRepository.save(account);
        return convertToDTO(savedAccount);
    }

    // Utility method to generate a unique account number
    private String generateAccountNumber() {
        return "ACC-" + System.currentTimeMillis(); // Example: ACC-1684234567890
    }

    // Utility method to hash the password
    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}