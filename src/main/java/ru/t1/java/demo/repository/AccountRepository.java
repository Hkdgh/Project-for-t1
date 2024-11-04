
package ru.t1.java.demo.repository;


import ru.t1.java.demo.entities.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AccountRepository {
    private final Map<UUID, Account> accounts = new HashMap<>();
    public void deleteAccount(UUID id) {
        accounts.remove(id);
    }
    public Account getAccount(UUID clientId) {
        return accounts.get(clientId);
    }

    public void saveAccount(Account account) {
        accounts.put(account.getClientId(), account);
    }
}
