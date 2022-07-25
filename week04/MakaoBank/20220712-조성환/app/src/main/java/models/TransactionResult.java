package models;

public class TransactionResult {

  private Transaction transaction;
  private int amount = 0;

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
  public boolean equals(Object other) {
    TransactionResult otherTransactionResults = (TransactionResult) other;
    return this.transaction.equals(otherTransactionResults.transaction) &&
        this.amount == otherTransactionResults.amount;
  }

  @Override
  public String toString() {
    return "TransactionResults(" + transaction.toString() + "잔액:: " + amount + ")";
  }

  public String csvToRow() {
    return String.join(",", values());
  }
}
