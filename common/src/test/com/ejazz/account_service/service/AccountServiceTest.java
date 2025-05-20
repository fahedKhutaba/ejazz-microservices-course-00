package com.ejazz.account_service.service;

import com.ejazz.account_service.dto.AccountDTO;
import com.ejazz.account_service.entity.Account;
import com.ejazz.account_service.exception.AuthenticationFailedException;
import com.ejazz.account_service.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountServiceTest {

    private AccountRepository accountRepository;
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        accountRepository = mock(AccountRepository.class);
        accountService = new AccountService(accountRepository);
    }

    @Test
    void authenticate_success() {
        String email = "user@example.com";
        String rawPassword = "password123";
        String hashedPassword = BCrypt.hashpw(rawPassword, BCrypt.gensalt());

        Account account = new Account();
        account.setEmail(email);
        account.setPassword(hashedPassword);

        when(accountRepository.findByEmail(email)).thenReturn(Optional.of(account));

        AccountDTO dto = accountService.authenticate(email, rawPassword);

        assertEquals(email, dto.getEmail());
    }

    @Test
    void authenticate_invalidPassword_throwsException() {
        String email = "user@example.com";
        String rawPassword = "password123";
        String wrongPassword = "wrongpass";
        String hashedPassword = BCrypt.hashpw(rawPassword, BCrypt.gensalt());

        Account account = new Account();
        account.setEmail(email);
        account.setPassword(hashedPassword);

        when(accountRepository.findByEmail(email)).thenReturn(Optional.of(account));

        assertThrows(AuthenticationFailedException.class, () ->
                accountService.authenticate(email, wrongPassword));
    }

    @Test
    void authenticate_userNotFound_throwsException() {
        String email = "notfound@example.com";
        when(accountRepository.findByEmail(email)).thenReturn(Optional.empty());

        assertThrows(AuthenticationFailedException.class, () ->
                accountService.authenticate(email, "anyPassword"));
    }

    @Test
void convertToDTO_shouldMapAllFields() {
    Account account = new Account();
    account.setAccountNumber("123");
    account.setEmail("test@example.com");
    account.setFirstName("John");
    account.setFamilyName("Doe");
    account.setBirthDate(LocalDate.of(1990, 1, 1));
    account.setPhoneNumber("+1234567890");
    account.setAddress("123 Main St");
    account.setCreatedAt(LocalDateTime.now());
    account.setUpdatedAt(LocalDateTime.now());

    AccountDTO dto = accountService.convertToDTO(account);

    assertEquals(account.getAccountNumber(), dto.getAccountNumber());
    assertEquals(account.getEmail(), dto.getEmail());
    // ...assert other fields...
}
@Test
void authenticate_shouldThrow_whenUserNotFound() {
    when(accountRepository.findByEmail("notfound@example.com")).thenReturn(Optional.empty());
    assertThrows(AuthenticationFailedException.class, () ->
        accountService.authenticate("notfound@example.com", "password"));
}

@WebMvcTest(AccountController.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    void authenticate_shouldReturnOk_whenCredentialsAreValid() throws Exception {
        AuthenticationRequest req = new AuthenticationRequest();
        req.setEmail("user@example.com");
        req.setPassword("password");

        AccountDTO dto = new AccountDTO();
        dto.setEmail("user@example.com");

        when(accountService.authenticate(anyString(), anyString())).thenReturn(dto);

        mockMvc.perform(post("/api/accounts/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"user@example.com\",\"password\":\"password\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("user@example.com"));
    }
}
}
