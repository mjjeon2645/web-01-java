package utils;

import models.Account;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AccountsLoader {
  public Map<String, Account> load() throws FileNotFoundException {
    Map<String, Account> accounts = new HashMap<>();

    File file = new File("accountsdata.csv");

    Scanner scanner = new Scanner(file);

    while(scanner.hasNextLine()) {
      String line = scanner.nextLine();

      Account account = parse(line);

      accounts.put(account.id(), account);
    }

    return accounts;
  }

  public void save(Map<String, Account> accounts) throws IOException {
    FileWriter fileWriter = new FileWriter("accountsdata.csv");

    for (Account account : accounts.values()) {
      String line = account.toCsvRow();
      fileWriter.write(line + "\n");
    }

    fileWriter.close();
  }

  public Account parse(String line) {
    String[] words = line.split(",");
    return new Account(words[0], words[1], words[2], words[3]);
  }
}
