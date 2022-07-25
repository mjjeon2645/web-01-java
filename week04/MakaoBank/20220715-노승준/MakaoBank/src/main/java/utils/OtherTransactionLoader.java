package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OtherTransactionLoader {
  public List<String> loadOtherTransaction() throws FileNotFoundException {
    List<String> otherTransactions = new ArrayList<>();

    File file = new File("otherTransaction.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      otherTransactions.add(line);
    }
    return otherTransactions;
  }
}
