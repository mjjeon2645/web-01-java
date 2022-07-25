import models.Account;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OtherAccountWriter {

  public OtherAccountWriter(Account otherAccount) throws IOException {
    FileWriter fileWriter = new FileWriter("otherAccount.csv");

    int amount = otherAccount.amount();
    List<String> transactions = otherAccount.transactions();

    fileWriter.write("잔액:" + amount + "\n");

    for (String transaction : transactions) {
      fileWriter.write(transaction + "\n");
    }
    fileWriter.close();
  }
}
