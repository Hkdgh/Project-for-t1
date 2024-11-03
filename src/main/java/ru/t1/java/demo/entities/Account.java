// Account.java
package com.project_name.entities;

import java.util.UUID;

public class Account {
    private UUID clientId;             // Идентификатор клиента
    private AccountType accountType;    // Дебетовый или кредитный счет
    private double balance;             // Баланс счета

    // Перечисление для типа счета
    public enum AccountType {
        DEBIT, CREDIT
    }

    // Конструктор
    public Account(UUID clientId, AccountType accountType, double balance) {
        this.clientId = clientId;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Геттеры и сеттеры
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
