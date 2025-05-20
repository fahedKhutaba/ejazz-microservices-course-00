package com.ejazz.account_service.controller;

import com.ejazz.account_service.dto.AuthenticationRequest;
import com.ejazz.common.exception.AuthenticationFailedException;
import com.ejazz.account_service.dto.AccountDTO;
import com.ejazz.account_service.dto.CreateAccountDTO;
import com.ejazz.account_service.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Operation(
        summary = "Get all accounts",
        description = "Retrieve a list of all user accounts in the system."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved list of accounts"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<AccountDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @Operation(
        summary = "Get account by ID",
        description = "Retrieve details of a specific account by its ID."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved account details"),
        @ApiResponse(responseCode = "404", description = "Account not found")
    })
    @GetMapping("/{id}")
    public AccountDTO getAccountById(
        @PathVariable Long id
    ) {
        return accountService.getAccountById(id);
    }

    @PostMapping
    @Operation(
        summary = "Create a new account",
        description = """
            Create a new user account with the provided details. 
            A unique identifier (`accountNumber`) will be generated automatically for use between services. 
            The password will be securely encrypted before being stored in the database.
            
            **Note**: Consider moving the authentication logic to a separate service in the future for better scalability and separation of concerns.
        """,
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Details of the account to be created",
            required = true,
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = CreateAccountDTO.class),
                examples = @ExampleObject(
                    name = "Create Account Example",
                    value = """
                        {
                          "email": "john.doe@example.com",
                          "password": "securepassword",
                          "firstName": "John",
                          "familyName": "Doe",
                          "birthDate": "1990-01-01",
                          "phoneNumber": "+1234567890",
                          "address": "123 Main St"
                        }
                        """
                )
            )
        )
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Account successfully created"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public AccountDTO createAccount(@RequestBody CreateAccountDTO createAccountDTO) {
        return accountService.saveAccount(createAccountDTO);
    }

        @PostMapping("/authenticate")
    public ResponseEntity<AccountDTO> authenticate(@RequestBody AuthenticationRequest request) {
        AccountDTO account = accountService.authenticate(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(account);
    }
}
