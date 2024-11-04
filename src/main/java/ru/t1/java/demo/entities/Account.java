package ru.t1.java.demo.entities;

import java.util.UUID;

public class Account {
    private UUID clientId;
    private AccountType accountType;
    private double balance; // Изменено на double

    public enum AccountType {
        DEBIT, CREDIT
    }

    public Account(UUID clientId, AccountType accountType, double balance) {
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

    public double getBalance() { // Изменено на double
        return balance;
    }

    public void setBalance(double balance) { // Изменено на double
        this.balance = balance;
    }
}