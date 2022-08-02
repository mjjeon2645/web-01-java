package repositories;

import models.*;

import java.util.*;

public class AccountRepository {
  private Map<String, Account> accounts = new HashMap<>();

  public AccountRepository() {
    List.of(
        new Account("1234", "ashal", 3000),
        new Account("2345", "joker", 1000)
    ).stream().forEach(account -> accounts.put(account.identifier(), account));
  }

  public Account find(String identifier) {
    return accounts.get(identifier);
  }

  public Account find(String identifier, String nextIdentifier) {
    Account account = find(identifier);
    if (account == null) {
      account = find(nextIdentifier);
    }

    return account;
  }
}
