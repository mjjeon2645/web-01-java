package models;

public class Transaction {
  private String type;
  private int amount;

  public Transaction(String type, int amount) {
    this.type = type;
    this.amount = amount;
  }

  @Override
  public boolean equals(Object other) {
    Transaction otherTransaction = (Transaction) other;
    return this.type.equals(otherTransaction.type) &&
        this.amount == otherTransaction.amount;
  }
}
