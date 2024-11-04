package ru.t1.java.demo.entities;

import org.junit.jupiter.api.Test;
import ru.t1.java.demo.entities.Account;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

public class AccountTest {

    @Test
    public void testAccountCreation() {
        UUID clientId = UUID.randomUUID();
        Account.AccountType accountType = Account.AccountType.DEBIT;
        double initialBalance = 1000.0; // Оставлено как double

        Account account = new Account(clientId, accountType, initialBalance);

        assertEquals(clientId, account.getClientId());
        assertEquals(accountType, account.getAccountType());
        assertEquals(initialBalance, account.getBalance(), 0.001); // Оставлено как double
    }

    @Test
    public void testAccountBalanceUpdate() {
        Account account = new Account(UUID.randomUUID(), Account.AccountType.CREDIT, 500.0); // Оставлено как double
        account.setBalance(700.0); // Оставлено как double

        assertEquals(700.0, account.getBalance(), 0.001); // Оставлено как double
    }
}
