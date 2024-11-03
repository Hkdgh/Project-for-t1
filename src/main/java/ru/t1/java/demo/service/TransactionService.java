package com.project_name.services;

import com.project_name.entities.Account;
import com.project_name.entities.Transaction;
import com.project_name.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    public Transaction processTransaction(UUID accountId, long amount) {
        Account account = accountRepository.getAccount(accountId);
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }

        account.setBalance(account.getBalance() + amount);
        accountRepository.saveAccount(account);

        return new Transaction(accountId, amount);
    }
}
