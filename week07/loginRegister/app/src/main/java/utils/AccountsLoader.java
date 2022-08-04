package utils;

import models.Account;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AccountsLoader {
  public Map<String, Account> load() throws FileNotFoundException {
    Map<String, Account> accounts = new HashMap<>();

    File file = new File("accountsdata.csv");

    Scanner scanner = new Scanner(file);

    while(scanner.hasNextLine()) {
      String line = scanner.nextLine();

      Account account = parse(line);

      accounts.put(account.id(),  account);
    }

    return accounts;
  }

//  public List<Account> load() throws FileNotFoundException {
//    List<Account> accounts = new ArrayList<>();
//
//    File file = new File("accountsdata.csv");
//
//    Scanner scanner = new Scanner(file);
//
//    while(scanner.hasNextLine()) {
//      String line = scanner.nextLine();
//
//      Account account = parse(line);
//
//      accounts.add(account);
//    }
//
//    return accounts;
//  }

  public Account parse(String line) {
    String[] words = line.split(",");
    return new Account(words[0], words[1], words[2], words[3]);
  }
}
