package ru.t1.java.demo.entities;

import java.time.Instant;
import java.util.UUID;

public class Transaction {
    private UUID accountId;
    private long transactionAmount;
    private Instant transactionTime;

    public Transaction(UUID accountId, long transactionAmount) {
        this.accountId = accountId;
        this.transactionAmount = transactionAmount;
        this.transactionTime = Instant.now();
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Instant getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Instant transactionTime) {
        this.transactionTime = transactionTime;
    }
}
