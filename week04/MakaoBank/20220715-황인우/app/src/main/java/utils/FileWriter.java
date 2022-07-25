package utils;

import models.Account;

import java.io.IOException;
import java.util.List;

public class FileWriter {
  public void saveAccount(Account account, String path) throws IOException {
    java.io.FileWriter fileWriter = new java.io.FileWriter(path);

    String identifier = account.identifier();
    long amount = account.amount();
    List<String> transactions = account.transactions();

    fileWriter.write("계좌번호," + identifier + "\n");
    fileWriter.write("잔액," + amount + "\n");

    for (String transaction : transactions) {
      String type = transaction.contains("출금") ? "출금" : "입금";
      String transferAmount = transaction.replaceAll("\\D", "");

      fileWriter.write(type + "," + transferAmount + "\n");
    }

    fileWriter.close();
  }
}
