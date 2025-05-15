package com.ejazz.account_service.controller;

import com.ejazz.account_service.dto.AccountDTO;
import com.ejazz.account_service.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Operation(
        summary = "Create a new account",
        description = "Create a new user account with the provided details.",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Details of the account to be created",
            required = true,
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = AccountDTO.class),
                examples = @ExampleObject(
                    name = "Create Account Example",
                    value = "{\n  \"name\": \"Alice Johnson\",\n  \"email\": \"alice.johnson@example.com\",\n  \"password\": \"securepassword\"\n}"
                )
            )
        )
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Account successfully created"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    public AccountDTO createAccount(@RequestBody AccountDTO accountDTO) {
        return accountService.saveAccount(accountDTO);
    }
}
