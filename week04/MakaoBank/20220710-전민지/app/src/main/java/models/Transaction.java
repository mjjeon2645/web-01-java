package models;

import java.util.Objects;

public class Transaction {
  private final String type;
  private final long amount;

  public Transaction(String type, long amount) {

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
    return "Transaction(" + type + ": " + amount + ")";
  }

  public String type() {
    return type;
  }

  public Long amount() {
    return amount;
  }

  public long process(long amount) {
    if (type.equals("잔액")) {
      return this.amount;
    }

    if (type.equals("입금")) {
      return amount + this.amount;
    }

    if (type.equals("출금")) {
      return amount - this.amount;
    }
    return amount;
  }
}
