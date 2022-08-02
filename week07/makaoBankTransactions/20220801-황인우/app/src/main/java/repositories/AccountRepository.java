package repositories;

import models.Account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepository {
  private final Map<String, Account> accounts = new HashMap<>();

  public AccountRepository() {
    List.of(
        new Account("352-0528", "Chikorita", 10000),
        new Account("179-20", "Eevee", 5000)
    ).stream().forEach(account -> {
      accounts.put(account.identifier(), account);
    });
  }

  public Account find(String identifier) {
    return accounts.get(identifier);
  }

  public Account find(String identifier, String otherIdentifier) {
    if (accounts.containsKey(identifier)) {
      return accounts.get(identifier);
    }

    return accounts.get(otherIdentifier);
  }
}
