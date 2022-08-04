package repositories;

import models.Account;
import utils.AccountsLoader;

import java.io.FileNotFoundException;
import java.util.Map;

public class AccountRepository {
  private Map<String, Account> accounts;

  public AccountRepository() throws FileNotFoundException {
    AccountsLoader accountsLoader = new AccountsLoader();
    accounts = accountsLoader.load();
  }

  public Account find(String id) {
    return accounts.get(id);
  }
}
