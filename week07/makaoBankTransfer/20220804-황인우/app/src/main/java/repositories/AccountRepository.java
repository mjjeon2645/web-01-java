package repositories;

import models.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class AccountRepository {
  private Map<String, Account> accounts = new HashMap<>();

  public AccountRepository() {
    Stream.of(
        new Account("110", "신태일", 2000),
        new Account("179", "매튜", 500),
        new Account("352", "아구몬", 10000)
    ).forEach(account -> accounts.put(account.identifier(), account));
  }

  public Account find(String identifier) {
    return accounts.get(identifier);
  }

  public Account find(String identifier, String nextIdentifier) {
    Account found = accounts.get(identifier);

    if (found == null) {
      found = accounts.get(nextIdentifier);
    }

    return found;
  }
}
