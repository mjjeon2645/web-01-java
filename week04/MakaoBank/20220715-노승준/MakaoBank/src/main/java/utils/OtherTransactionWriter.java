package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OtherTransactionWriter {
  public void writeTransaction(List<String> otherTransactions) throws IOException {
    FileWriter fileWriter = new FileWriter("otherTransaction.csv");

    for (String otherTransaction : otherTransactions) {
      fileWriter.write(otherTransaction + "\n");
    }

    fileWriter.close();
  }
}
