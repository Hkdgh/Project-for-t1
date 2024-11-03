// Transaction.java
package com.project_name.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private UUID accountId;             // Идентификатор счета
    private double transactionAmount;    // Сумма транзакции
    private LocalDateTime transactionTime; // Время транзакции

    // Конструктор
    public Transaction(UUID accountId, double transactionAmount) {
        this.accountId = accountId;
        this.transactionAmount = transactionAmount;
        this.transactionTime = LocalDateTime.now(); // Устанавливаем текущее время
    }

    // Геттеры и сеттеры
    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }
}
