package models;

import java.util.*;

public class Transaction {
  private int amount;
  private String type;

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
    return (Objects.equals(this.type, ((Transaction) other).type)
        && this.amount == ((Transaction) other).amount);
  }

  @Override
  public String toString() {
    return "Transaction(" + type + "," + amount + ")";
  }

  public int amount() {
    return amount;
  }

  public String type() {
    return this.type;

  }

  public int process(int amount) {
    if(type.equals("잔액")) {
      return this.amount;
    }
    if(type.equals("입금")) {
      return amount + this.amount;
    }
    if(type.equals("출금")) {
      return amount - this.amount;
    }
    return amount;
    }

}
