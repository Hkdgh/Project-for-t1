// src/main/java/com/project_name/controllers/AccountController.java
package com.project_name.controllers;

import com.project_name.entities.Account;
import com.project_name.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    // Получить аккаунт по ID
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable UUID id) {
        Account account = accountRepository.getAccount(id);
        return account != null ? ResponseEntity.ok(account) : ResponseEntity.notFound().build();
    }

    // Создать новый аккаунт
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        accountRepository.saveAccount(account);
        return ResponseEntity.ok(account);
    }

    // Обновить баланс аккаунта
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccountBalance(@PathVariable UUID id, @RequestBody Account updatedAccount) {
        Account account = accountRepository.getAccount(id);
        if (account == null) {
            return ResponseEntity.notFound().build();
        }
        account.setBalance(updatedAccount.getBalance());
        accountRepository.saveAccount(account);
        return ResponseEntity.ok(account);
    }

    // Удалить аккаунт
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable UUID id) {
        if (accountRepository.getAccount(id) != null) {
            accountRepository.deleteAccount(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}