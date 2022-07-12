package models;

import java.util.Objects;

public class Transaction {
  private final String type;
  private final int amount;

  public Transaction(String type, int amount) {
    this.type = type;
    this.amount = amount;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object other) {
    Transaction otherTransaction = (Transaction) other;

    return Objects.equals(this.type, otherTransaction.type)
        && this.amount == otherTransaction.amount;
  }

  @Override
  public String toString() {
    return "(Transaction) " + this.type + ", " + this.amount;
  }
}
