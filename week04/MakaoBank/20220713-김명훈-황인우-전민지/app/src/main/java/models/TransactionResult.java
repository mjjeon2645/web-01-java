package models;

public class TransactionResult {
  private Transaction transaction;
  private int result;

  public TransactionResult(Transaction transaction, int result) {
    this.transaction = transaction;
    this.result = result;
  }

  @Override
  public boolean equals(Object other) {
    TransactionResult otherTransactionResult = (TransactionResult) other;
    return this.transaction == otherTransactionResult.transaction &&
    this.result == otherTransactionResult.result;
  }
}
