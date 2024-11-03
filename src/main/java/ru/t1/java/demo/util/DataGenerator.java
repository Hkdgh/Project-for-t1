// src/main/java/com/project_name/util/DataGenerator.java
package com.project_name.util;

import com.project_name.entities.Account;
import com.project_name.entities.Transaction;
import com.project_name.repositories.AccountRepository;
import com.project_name.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Component
public class DataGenerator {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionService transactionService;

    @PostConstruct
    public void generateData() {
        for (int i = 0; i < 10; i++) {
            UUID clientId = UUID.randomUUID();
            Account account = new Account(clientId, Account.AccountType.DEBIT, Math.random() * 10000);
            accountRepository.saveAccount(account);

            // Создаем транзакции для каждого аккаунта
            for (int j = 0; j < 5; j++) {
                transactionService.processTransaction(clientId, Math.random() * 1000 - 500); // случайные значения
            }
        }
    }
}
