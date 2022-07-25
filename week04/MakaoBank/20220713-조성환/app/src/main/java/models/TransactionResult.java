package models;

public class TransactionResult {
  private Transaction transaction;
  private int amount;

  public TransactionResult(Transaction transaction, int amount) {

    this.transaction = transaction;
    this.amount = amount;
  }
}
