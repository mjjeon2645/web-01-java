import models.Account;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyAccountWriter {
  public MyAccountWriter(Account myAccount) throws IOException {
    FileWriter fileWriter = new FileWriter("myAccount.csv");

    int amount = myAccount.amount();
    List<String> transactions = myAccount.transactions();

    fileWriter.write("잔액:" + amount + "\n");

    for (String transaction : transactions) {
      fileWriter.write(transaction + "\n");
    }
    fileWriter.close();
  }
}
