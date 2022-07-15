package utils;

import models.Account;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyTransactionsLoader {
  public Account accountLoader() throws FileNotFoundException {
    String identifier = "";
    int amount = 0;
    List<String> myTransactions = new ArrayList<>();

    File file = new File("mytransactions.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      String[] words = line.split(",");

      if (words[0].equals("계좌번호")) {
        identifier = words[1];
      }

      if (words[0].equals("잔액")) {
        amount = Integer.parseInt(words[1]);
      }

      if (words[0].equals("입금") || words[0].equals("출금")) {
        myTransactions.add(words[0] + "," + words[1]);
      }
    }

    return new Account(identifier, amount, myTransactions);
  }
}
