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
    return amount;
  }

  @Override
  public boolean equals(Object other) {
    Transaction otherTransaction = (Transaction) other;

    return (Objects.equals(this.type, otherTransaction.type)
        && this.amount == otherTransaction.amount);
  }

  @Override
  public String toString() {
    return "(Transaction) " + this.type + ": " + this.amount;
  }

  public String type() {
    return this.type;
  }

  public Integer amount() {
    return this.amount;
  }

  public int process(int amount) {
    if (this.type.equals("잔액")) {
      return this.amount;
    }
    if (this.type.equals("입금")) {
      return amount + this.amount;
    }
    if (this.type.equals("출금")) {
      return amount - this.amount;
    }
    return amount;
  }
}
