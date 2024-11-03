// src/main/java/com/project_name/services/TransactionService.java
package com.project_name.services;

import com.project_name.entities.Account;
import com.project_name.entities.Transaction;
import com.project_name.repositories.AccountRepository;

import java.util.UUID;

public class TransactionService {
    private final AccountRepository accountRepository;

    public TransactionService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Метод для выполнения транзакции
    public Transaction processTransaction(UUID accountId, double amount) throws IllegalArgumentException {
        Account account = accountRepository.getAccount(accountId);

        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }

        // Обновление баланса
        account.setBalance(account.getBalance() + amount);
        accountRepository.saveAccount(account);

        // Возвращаем новую транзакцию с текущим временем
        return new Transaction(accountId, amount);
    }
}
