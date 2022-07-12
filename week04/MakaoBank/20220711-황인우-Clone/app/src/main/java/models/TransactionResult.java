package models;

public class TransactionResult {
  // 거래 내역은 '참조'하고 잔액만 들고 있도록 함

  private final Transaction transaction;
  private final int amount;

  public TransactionResult(Transaction transaction, int amount) {
    this.transaction = transaction;
    this.amount = amount;
  }

  public String[] values() {
    return new String[]{
        transaction.type(),
        transaction.amount().toString(),
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

    return this.transaction == otherTransactionResult.transaction
        && this.amount == otherTransactionResult.amount;
  }

  @Override
  public String toString() {
    return "(TransactionResult) " + transaction.toString() +
        " >> " + this.amount;
  }

  public String toCsvRow() {
    return String.join(",", this.values());
  }
}
