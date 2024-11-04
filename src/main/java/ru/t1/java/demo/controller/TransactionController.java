package ru.t1.java.demo.controllers;

import ru.t1.java.demo.entities.Transaction;
import ru.t1.java.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        try {
            Transaction newTransaction = transactionService.processTransaction(
                    transaction.getAccountId(), transaction.getTransactionAmount());
            return ResponseEntity.ok(newTransaction);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
