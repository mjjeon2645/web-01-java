package repository;

import models.*;

import java.util.*;
import java.util.stream.*;

public class AccountRepository {
  private Map<String, Account> accounts = new HashMap<>();

  public AccountRepository() {
    Stream.of(
        new Account("1234", "ashal", 3000),
        new Account("2345", "joker", 1000)
    ).forEach(account -> accounts.put(account.identifier(), account));
  }

  public Account find(String identifier) {

    return accounts.get(identifier);
  }

  public Account find(String identifier,String accountIdentifier) {
    Account found = find(identifier);
    if(found == null)
      found = find(accountIdentifier);
    return found;
  }
}
