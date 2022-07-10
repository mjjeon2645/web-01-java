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
    // 입력

    Account account = new Account();

    List<Transaction> transactions = loadTransactions();


    // 처리

    List<TransactionResult> transactionResults = account.process(transactions);


    // 출력
    saveTransactionsResults(transactionResults);


  }

  public List<Transaction> loadTransactions() throws FileNotFoundException {
    List<Transaction> transactions = new ArrayList<>();

    File file = new File("input.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {

      String line = scanner.nextLine();

      Transaction transaction = parseTransaction(line);

      transactions.add(transaction);
    }

    return transactions;
  }

  public Transaction parseTransaction(String text) {
    String[] words = text.split(",");
    long amount = Long.parseLong(words[1]);

    return new Transaction(words[0], amount);
  }

  public void saveTransactionsResults(
      List<TransactionResult> transactionResults) throws IOException {
    FileWriter fileWriter = new FileWriter("output.csv");

    for (TransactionResult transactionResult : transactionResults) {

      String line = transactionResult.toCsvRow();

      fileWriter.write(line + "\n");
    }

    fileWriter.close();
  }
}
