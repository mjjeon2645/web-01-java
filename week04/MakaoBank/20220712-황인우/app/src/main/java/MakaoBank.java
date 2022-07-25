import models.Account;
import models.Transaction;
import models.TransactionResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MakaoBank {
  public static void main(String[] args) throws IOException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public void run() throws IOException {
    Account account = new Account();

    List<Transaction> transactions = loadTransactions();

    List<TransactionResult> transactionResults = account.process(transactions);

    saveTransactionResults(transactionResults);
  }

  public List<Transaction> loadTransactions() throws FileNotFoundException {
    File file = new File("input.csv");

    Scanner scanner = new Scanner(file);

    ArrayList<Transaction> transactions = new ArrayList<>();

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      Transaction transaction = parseTransaction(line);

      transactions.add(transaction);
    }

    return transactions;
  }

  public Transaction parseTransaction(String line) {
    String[] words = line.split(",");

    String type = words[0];
    int amount = Integer.parseInt(words[1]);

    return new Transaction(type, amount);
  }

  public void saveTransactionResults(
      List<TransactionResult> transactionResults) throws IOException {
    FileWriter fileWriter = new FileWriter("output.csv");

    for (TransactionResult transactionResult : transactionResults) {
      String line = transactionResult.getCsvRow();

      fileWriter.write(line + "\n");
    }

    fileWriter.close();
  }
}
