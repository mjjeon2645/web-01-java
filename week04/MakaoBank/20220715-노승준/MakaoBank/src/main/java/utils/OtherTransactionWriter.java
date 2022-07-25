package utils;

import models.Account;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OtherTransactionWriter {
  private Account account;

  public void writeTransaction(
      Account account,
      List<String> otherTransactions) throws IOException {
    this.account = account;

    FileWriter fileWriter = new FileWriter("otherTransaction.csv");

    for (String otherTransaction : otherTransactions) {
      fileWriter.write(otherTransaction + "\n");
    }

    String amount = String.valueOf(account.otherAmount());
    fileWriter.write("잔액 :" + amount + "원");

    fileWriter.close();
  }
}
