package models;

import java.util.ArrayList;
import java.util.List;

public class Account {
  private int finalAmount = 0;

  public List<TransactionResult> process(List<Transaction> transactions) {
    List<TransactionResult> transactionResults = new ArrayList<>();

    for (Transaction transaction : transactions) {
      finalAmount = transaction.process(finalAmount);

      TransactionResult transactionResult
          = new TransactionResult(transaction, finalAmount);
      transactionResults.add(transactionResult);
    }

    return transactionResults;
  }
}
