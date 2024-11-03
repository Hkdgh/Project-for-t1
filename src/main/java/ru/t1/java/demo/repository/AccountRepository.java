
package com.project_name.repositories;

import com.project_name.entities.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AccountRepository {
    private final Map<UUID, Account> accounts = new HashMap<>();

    public Account getAccount(UUID clientId) {
        return accounts.get(clientId);
    }

    public void saveAccount(Account account) {
        accounts.put(account.getClientId(), account);
    }
}
