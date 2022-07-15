package utils;

import models.TheOtherAccount;

import java.io.FileWriter;
import java.io.IOException;

public class TheOtherTransactionsSaver {
  public TheOtherTransactionsSaver(TheOtherAccount theOtherAccount) throws IOException {
    FileWriter fileWriter = new FileWriter("theothertransactions.csv");

    for (String transaction : theOtherAccount.theOtherTransactions()) {
      fileWriter.write(transaction + "\n");
    }
    fileWriter.close();
  }
}
