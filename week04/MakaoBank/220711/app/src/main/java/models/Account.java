package models;

import java.util.*;

public class Account {
  private int amount;

  public List<TransactionResult> process(List<Transaction> transactions) {
    List<TransactionResult> transactionResults = new ArrayList<>();

    for(Transaction transaction : transactions) {
      TransactionResult transactionResult
          = new TransactionResult(transaction, amount);
      transactionResults.add(transactionResult);
    }
    return transactionResults;
  }
  //TODO: 잔액 관리 필요!
}
