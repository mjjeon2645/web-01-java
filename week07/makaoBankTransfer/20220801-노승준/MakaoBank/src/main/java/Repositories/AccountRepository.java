package Repositories;

import models.Account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepository {
  private Map<String, Account> accounts = new HashMap<>();

  public AccountRepository() {
    List.of(
        new Account("1234", "ashal", 3000),
        new Account("2345", "joker", 1000)
    ).stream().forEach(account ->
        accounts.put(account.identifier(), account));
  }

  public Account find(String identifier) {
    return accounts.get(identifier);
  }
}
