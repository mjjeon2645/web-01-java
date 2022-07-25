package models;

public class TransactionResult {
  private final Transaction transaction;
  private final int amount;

  public TransactionResult(Transaction transaction, int amount) {
    this.transaction = transaction;
    this.amount = amount;
  }
  @Override
  public int hashCode() {
    return 0;
  }
  @Override
  public boolean equals(Object other) {
    TransactionResult otherTransactionResult = (TransactionResult) other;

    return this.transaction.equals(((TransactionResult) other).transaction)
        && this.amount == ((TransactionResult) other).amount;
  }

  public String[] values() {
    return new String[] {transaction.type(),Integer.toString(transaction.amount()),Integer.toString(amount)};
  }

  public String toCsvRow() {
    return String.join(",",values());
  }
}
