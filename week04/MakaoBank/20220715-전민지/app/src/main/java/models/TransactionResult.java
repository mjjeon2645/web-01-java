package models;

public class TransactionResult {
  private Transaction transaction;
  private int finalAmount;

  public TransactionResult(Transaction transaction, int finalAmount) {
    this.transaction = transaction;
    this.finalAmount = finalAmount;
  }

  public String[] values() {
    return new String[]{
        transaction.type(),
        transaction.amount().toString(),
        Integer.toString(finalAmount)};
  }

  @Override
  public String toString() {
    return "TransactionsResult(" + transaction +
        ", finalAmount: " + finalAmount + ")";
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object other) {
    TransactionResult otherTransactionResult = (TransactionResult) other;
    return this.transaction == otherTransactionResult.transaction &&
        this.finalAmount == otherTransactionResult.finalAmount;
  }

  public String toCsvRow() {
    return String.join(",", values());
  }
}
