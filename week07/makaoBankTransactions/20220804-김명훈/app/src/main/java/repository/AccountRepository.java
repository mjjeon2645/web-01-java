package repository;

import models.*;

import java.util.*;
import java.util.stream.*;

public class AccountRepository {
  private Map<String, Account> accountMap = new HashMap<>();

  public AccountRepository() {
    Stream.of(
        new Account("1234", "ashal", 3000),
        new Account("2345", "joker", 1000)
    ).forEach(account -> {
      accountMap.put(account.identifier(), account);
    });
  }

  public Account find(String identifier) {
    return accountMap.get(identifier);
  }

  public Account find(String identifier,String accountIdentifier) {

    if(identifier.equals("")) {
      return find(accountIdentifier);
    }
    Account account = find(identifier);
    return account;
  }
}
