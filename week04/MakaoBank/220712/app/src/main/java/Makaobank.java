import models.*;

import java.util.*;

public class Makaobank {
  public static void main(String[] args) {
    Makaobank application = new Makaobank();

    application.run();
  }

  public void run() {
    Account account = new Account();

    List<Transaction> transactions = loadTransactions();

  //  List<TransactionResult> transactionResults = account.process(transactions);

  //  saveTransactionResults(transactionResults);

  }

  public List<Transaction> loadTransactions() {
    List<Transaction> transactions = new ArrayList<>();
    Transaction transaction;
    transactions.add(transaction);
    return transactions;
  }
}
