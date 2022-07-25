import models.Account;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyAccountLoader {
  public Account loadAccount() throws FileNotFoundException {
    String identifer = "123-456";
    int amount = 0;
    List<String> transactions = new ArrayList<>();

    File file = new File("myAccount.csv");

    Scanner scanner = new Scanner(file);

    while(scanner.hasNextLine()){
      String line = scanner.nextLine();
      String[] words = line.split(":");

      if(line.contains("잔액")) {
        amount = Integer.parseInt(words[1]);
        continue;
      }
      transactions.add(line);
    }
    return new Account(identifer,amount,transactions);
  }
}
