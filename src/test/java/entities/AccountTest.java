
package com.project_name.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

public class AccountTest {

    @Test
    public void testAccountCreation() {
        UUID clientId = UUID.randomUUID();
        Account.AccountType accountType = Account.AccountType.DEBIT;
        double initialBalance = 1000.0;

        Account account = new Account(clientId, accountType, initialBalance);

        assertEquals(clientId, account.getClientId());
        assertEquals(accountType, account.getAccountType());
        assertEquals(initialBalance, account.getBalance(), 0.001);
    }

    @Test
    public void testAccountBalanceUpdate() {
        Account account = new Account(UUID.randomUUID(), Account.AccountType.CREDIT, 500.0);
        account.setBalance(700.0);

        assertEquals(700.0, account.getBalance(), 0.001);
    }
}
