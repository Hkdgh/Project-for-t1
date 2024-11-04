package ru.t1.java.demo.until;

import ru.t1.java.demo.entities.Account;
import ru.t1.java.demo.repository.AccountRepository;
import ru.t1.java.demo.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Component
public class DataGenerator {

    private static final Logger logger = LoggerFactory.getLogger(DataGenerator.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionService transactionService;

    @PostConstruct
    public void generateData() {
        for (int i = 0; i < 10; i++) {
            UUID clientId = UUID.randomUUID();
            long initialBalance = (long) (Math.random() * 100000);

            Account account = new Account(clientId, Account.AccountType.DEBIT, initialBalance);
            accountRepository.saveAccount(account);
            logger.info("Created account with clientId: {} and initial balance: {}", clientId, initialBalance);

            for (int j = 0; j < 5; j++) {
                long transactionAmount = (long) (Math.random() * 10000 - 5000);
                try {
                    transactionService.processTransaction(clientId, transactionAmount);
                    logger.info("Processed transaction for clientId: {} with amount: {}", clientId, transactionAmount);
                } catch (Exception e) {
                    logger.error("Failed to process transaction for clientId: {} with amount: {}", clientId, transactionAmount, e);
                }
            }
        }
    }
}
