import models.*;
import org.checkerframework.checker.units.qual.*;

import java.io.*;
import java.util.*;

public class MakaoBank {
  public static void main(String[] args) throws FileNotFoundException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public void run() throws FileNotFoundException {
    Account account = new Account();

    List<Transaction> transactions = loadTransactions();


    List<TransactionResult> transactionResults = account.process(transactions);

  // saveTransactionResults(transactionResults);
  }

  public List<Transaction> loadTransactions() throws FileNotFoundException {
    List<Transaction> transactions = new ArrayList<>();

    File file = new File("input.csv");


    Scanner scanner = new Scanner(file);

    while(scanner.hasNextLine()) {


      String line = scanner.nextLine();

      //TODO : 문자열을 객체로 변환하는게 필요 -> Parsing

      Transaction transaction = parseTransaction(line);
      transactions.add(transaction);
    }
    return transactions;
  }

  public Transaction parseTransaction(String text) {
    String[] word = text.split(",");
    int amount = Integer.valueOf(word[1]);
      return new Transaction(word[0],amount);
  }
}
