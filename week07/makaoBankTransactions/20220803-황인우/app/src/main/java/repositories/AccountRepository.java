package repositories;

import models.Account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepository {
  private final Map<String, Account> accounts = new HashMap<>();

  public AccountRepository() {
    List.of(
            new Account("110", "한지우", 10000),
            new Account("179", "오바람", 5000),
            new Account("352", "오박사", 20000)
        ).stream()
        .forEach(account -> {
          accounts.put(account.identifier(), account);
        });
  }

  public Account find(String identifier) {
    return accounts.get(identifier);
  }

  public Account find(String identifier, String nextIdentifier) {
    Account found = accounts.get(identifier);

    if (found != null) {
      return found;
    }

    return accounts.get(nextIdentifier);
  }
}
