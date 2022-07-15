import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class MyTransactionFileLoader {
  public MyTransactionFileLoader(List<String> myTransactions) throws FileNotFoundException {
    File file = new File("myAccount.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      myTransactions.add(line);
    }
  }
}
