package utils;

import models.Account;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
  public Account loadAccount(String path) throws FileNotFoundException {
    File file = new File(path);

    Scanner scanner = new Scanner(file);

    String identifier = "";
    long amount = 0;
    List<String> transactions = new ArrayList<>();

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      String[] words = line.split(",");

      switch (words[0]) {
        case "계좌번호" -> {
          identifier = words[1];
        }
        case "잔액" -> {
          amount = Long.parseLong(words[1]);
        }
        case "출금", "입금" -> {
          transactions.add(words[0] + ": " + words[1] + "원");
        }
      }
    }

    return new Account(identifier, amount, transactions);
  }
}
