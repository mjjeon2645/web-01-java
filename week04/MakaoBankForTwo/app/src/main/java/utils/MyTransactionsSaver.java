package utils;

import models.MyAccount;

import java.io.FileWriter;
import java.io.IOException;

public class MyTransactionsSaver {
  public MyTransactionsSaver(MyAccount myAccount) throws IOException {
    FileWriter fileWriter = new FileWriter("mytransactions.csv");

    for (String transaction : myAccount.myTransactions()) {
      fileWriter.write(transaction + "\n");
    }
    fileWriter.close();
  }
}
