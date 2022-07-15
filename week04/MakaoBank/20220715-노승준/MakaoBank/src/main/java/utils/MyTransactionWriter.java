package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyTransactionWriter {
  public void writeTransaction(
      List<String> myTransactions)
      throws IOException {

    FileWriter fileWriter = new FileWriter("myTransaction.csv");

    for (String myTransaction : myTransactions) {
      fileWriter.write(myTransaction + "\n");
    }

    fileWriter.close();
  }
}
