import models.Account;
import models.Transaction;
import models.TransactionResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MakaoBank {
  public static void main(String[] args) throws FileNotFoundException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  private void run() throws FileNotFoundException {
    Account account = new Account();

    List<Transaction> transactions = loadTransaction();

    List<TransactionResult> transactionResults = account.process(transactions);

  }

  public List<Transaction> loadTransaction() throws FileNotFoundException {
    List<Transaction> transactions = new ArrayList<>();

    File file = new File("/Users/seonghwan/Desktop/web01java/week04" +
        "/MakaoBank/20220713-조성환/input.csv");

    Scanner scanner = new Scanner(file);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      Transaction transaction = parseTransaction(line);

      transactions.add(transaction);
    }

    return transactions;
  }

  private Transaction parseTransaction(String text) {
    String[] words = text.split(",");
    int amount = Integer.parseInt(words[1]);

    return new Transaction(words[0], amount);
  }
}
