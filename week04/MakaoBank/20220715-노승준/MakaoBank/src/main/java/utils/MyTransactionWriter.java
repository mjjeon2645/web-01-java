package utils;

import models.Account;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyTransactionWriter {
  private Account account;

  public void writeTransaction(
      Account account,
      List<String> myTransactions)throws IOException {
    this.account = account;

    FileWriter fileWriter = new FileWriter("myTransaction.csv");

    for (String myTransaction : myTransactions) {
      fileWriter.write(myTransaction + "\n");
    }

    String amount = String.valueOf(account.myAmount());
    fileWriter.write("잔액 :" + amount + "원");

    fileWriter.close();
  }
}
