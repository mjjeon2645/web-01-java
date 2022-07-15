import models.Account;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class otherTransactionFileWriter {

  public otherTransactionFileWriter(Account otherAccount) throws IOException {
    FileWriter fileWriter = new FileWriter("otherAccount");

    int amount = otherAccount.amount();
    List<String> transactions = otherAccount.transactions();

    fileWriter.write(amount);

    for (String transaction : transactions) {
      fileWriter.write(transaction);
    }
    fileWriter.close();
  }
}
