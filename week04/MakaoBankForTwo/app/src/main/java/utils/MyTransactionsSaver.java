package utils;

import models.Account;

import java.io.FileWriter;
import java.io.IOException;

public class MyTransactionsSaver {
  public MyTransactionsSaver(Account myAccount) throws IOException {
    FileWriter fileWriter = new FileWriter("mytransactions.csv");

    fileWriter.write("계좌번호," + myAccount.identifier()+ "\n");

    fileWriter.write("잔액," + myAccount.amount()+ "\n");

    for (String transaction : myAccount.transactions()) {
      fileWriter.write(transaction + "\n");
    }

    fileWriter.close();
  }
}
