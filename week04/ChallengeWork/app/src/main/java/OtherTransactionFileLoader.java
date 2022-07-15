import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class OtherTransactionFileLoader {
  public OtherTransactionFileLoader(List<String> otherTransactions) throws FileNotFoundException {
    File file = new File("otherAccount.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      otherTransactions.add(line);
    }
  }
}
