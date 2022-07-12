package models;

import java.util.Objects;

public class TransactionResult {
  private final Transaction transaction;
  private final int amount;

  public TransactionResult(Transaction transaction, int amount) {
    this.transaction = transaction;
    this.amount = amount;
  }

  public String[] values() {
    return new String[]{
        this.transaction.type(),
        this.transaction.amount().toString(),
        Integer.toString(this.amount)
    };
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object other) {
    TransactionResult otherTransactionResult = (TransactionResult) other;

    return Objects.equals(this.transaction, otherTransactionResult.transaction)
        && this.amount == otherTransactionResult.amount;
  }

  @Override
  public String toString() {
    return "(TransactionResult) " + this.transaction.toString() +
        ", " + this.amount;
  }

  public String getCsvRow() {
    return String.join(",", this.values());
  }
}
