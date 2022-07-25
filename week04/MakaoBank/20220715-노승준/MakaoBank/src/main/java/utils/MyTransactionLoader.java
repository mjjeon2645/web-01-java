package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyTransactionLoader {
  public List<String> loadMyTransaction() throws FileNotFoundException {
    List<String> myTransactions = new ArrayList<>();

    File file = new File("myTransaction.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      myTransactions.add(line);
    }
    return myTransactions;
  }
}
