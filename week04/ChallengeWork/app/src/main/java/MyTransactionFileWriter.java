import models.Account;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyTransactionFileWriter {
  public MyTransactionFileWriter(Account myAccount) throws IOException {
    FileWriter fileWriter = new FileWriter("myAccount");

    int amount = myAccount.amount();
    List<String> transactions = myAccount.transactions();

    fileWriter.write(amount);

    for(String transaction : transactions){
      fileWriter.write(transaction);
    }
    fileWriter.close();
  }
}
