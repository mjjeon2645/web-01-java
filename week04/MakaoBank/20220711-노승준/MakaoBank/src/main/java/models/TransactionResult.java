package models;

import java.lang.annotation.Target;

public class TransactionResult {

  private Transaction transaction;
  private int amount;

  public TransactionResult(Transaction transaction, int amount) {

    this.transaction = transaction;
    this.amount = amount;
  }

  public String[] values() {
    return new String[]{transaction.type(),
        transaction.amount().toString(),
        Integer.toString(amount)};
  }

  @Override
  public String toString() {
    return "Transaction(" + transaction.toString() + ", 잔액: " + amount + ")";
  }

  @Override
  public boolean equals(Object other) {
    TransactionResult otherTransactionResult = (TransactionResult) other;
    return this.transaction == otherTransactionResult.transaction &&
        this.amount == otherTransactionResult.amount;
  }

  public String toCsvRow() {
    return String.join(",", values());
  }
}

