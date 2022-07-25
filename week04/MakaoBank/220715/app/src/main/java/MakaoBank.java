import models.*;

import java.io.*;
import java.util.*;

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

  public void saveTransactionResults(List<TransactionResult> transactionResults) throws IOException {

    FileWriter fileWriter = new FileWriter("output.csv");

    for (TransactionResult transactionResult : transactionResults) {
        String line = transactionResult.toCsvRow();
        fileWriter.write(line + "\n");
    }
    fileWriter.close();
  }

  public List<Transaction> loadTransactions() throws FileNotFoundException {

    File file = new File("input.csv");
    Scanner scanner = new Scanner(file);
    List<Transaction> transactions = new ArrayList<>();
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      Transaction transaction = parseTransaction(line);
      transactions.add(transaction);
    }
    return transactions;
  }

  private Transaction parseTransaction(String text) {
    String[] words = text.split(",");
    String type = words[0];
    Integer amount = Integer.parseInt(words[1]);
    return new Transaction(type,amount);
  }
}
