package utils;

import models.Account;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountsLoader {
  public List<Account> load() throws FileNotFoundException {
    List<Account> accounts = new ArrayList<>();

    File file = new File("accountsdata.csv");

    Scanner scanner = new Scanner(file);

    while(scanner.hasNextLine()) {
      String line = scanner.nextLine();

      Account account = parse(line);

      accounts.add(account);
    }

    return accounts;
  }

  public Account parse(String line) {
    String[] words = line.split(",");
    return new Account(words[0], words[1], words[2], words[3]);
  }
}
