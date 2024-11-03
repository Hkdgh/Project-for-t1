package com.project_name.entities;

import java.util.UUID;

public class Account {
    private UUID clientId;
    private AccountType accountType;
    private long balance;

    public enum AccountType {
        DEBIT, CREDIT
    }

    public Account(UUID clientId, AccountType accountType, long balance) {
        this.clientId = clientId;
        this.accountType = accountType;
        this.balance = balance;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
