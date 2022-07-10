package models;

public class TransactionResult {

  private final Transaction transaction;
  private final long amount;

  public TransactionResult(Transaction transaction, long amount) {

    this.transaction = transaction;
    this.amount = amount;
  }

  public String[] values() {
    return new String[]{
        transaction.type(),
        transaction.amount().toString(),
        Long.toString(amount)};
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object other) {
    TransactionResult otherTransactionResult = (TransactionResult) other;
    return this.transaction == otherTransactionResult.transaction &&
        this.amount == otherTransactionResult.amount;
  }

  @Override
  public String toString() {
    return "TransactionResult(" + transaction.toString()
        + ", 잔액: " + amount + ")";
  }

  public String toCsvRow() {
    return String.join(",", values());
  }
}
