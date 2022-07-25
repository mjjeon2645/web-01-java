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
    // 준비
    Account account = new Account();

    // 입력
    List<Transaction> transactions = loadTransactions();

    // 처리
    List<TransactionResult>transactionResults = account.process(transactions);

    // 출력
    saveTransactionResults(transactionResults);
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
    int amount = Integer.parseInt(words[1]);
    return new Transaction(words[0], amount);
  }

  public void saveTransactionResults(
      List<TransactionResult> transactionResults) throws IOException {
    FileWriter fileWriter = new FileWriter("output.csv");

    for (TransactionResult transactionResult : transactionResults) {
      String line = transactionResult.toCsvRow();
      fileWriter.write(line + "\n");
    }

    fileWriter.close();
  }
}
