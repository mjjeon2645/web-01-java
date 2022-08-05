package Repositories;

import models.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
  private List<Account> accounts = new ArrayList<>();

  public AccountRepository() {
    List.of(
        new Account("352", "치코리타", 10000),
        new Account("179", "파이리", 10000)
    ).stream().forEach(account -> {
      accounts.add(account);
    });
  }

  public Account find(String identifier) {
    return accounts.stream()
        .filter(account -> account.identifier().equals(identifier))
        .findFirst()
        .get();
  }

  public Account find(String identifier, String myIdentifier) {
    return accounts.stream()
        .filter(account -> account.identifier().equals(identifier))
        .findFirst()
        .orElse(find(myIdentifier));
  }
}
