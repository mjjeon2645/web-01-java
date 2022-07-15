import models.Account;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyTransactionFileLoader {
  public Account loadAccount() throws FileNotFoundException {
    String identifer = "123-456";
    int amount = 0;
    List<String> transactions = new ArrayList<>();

    File file = new File("myAccount.csv");

    Scanner scanner = new Scanner(file);

    while(scanner.hasNextLine()){
      String line = scanner.nextLine();
      String[] words = line.split(",");

      amount = Integer.parseInt(words[1]);

      transactions.add(line);
    }
    return new Account(identifer,amount,transactions);
  }
}
