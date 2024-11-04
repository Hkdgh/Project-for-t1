package ru.t1.java.demo.service;

import ru.t1.java.demo.entities.Account;
import ru.t1.java.demo.entities.Transaction;
import ru.t1.java.demo.repository.AccountRepository;
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
