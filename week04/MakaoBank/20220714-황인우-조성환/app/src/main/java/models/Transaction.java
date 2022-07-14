package models;

public class Transaction {
  private String type;
  private int amount;

  public Transaction(String type, int amount) {
    this.type = type;
    this.amount = amount;
  }

  public String type() {
    return this.type;
  }

  public Integer amount() {
    return this.amount;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object other) {
    Transaction otherTransaction = (Transaction) other;
    return this.type.equals(otherTransaction.type) &&
        this.amount == otherTransaction.amount;
  }

  @Override
  public String toString() {
    return "(Transaction) type: " + this.type + ", amount: " + this.amount;
  }

  public int process(int amount) {
    if (type.equals("입금")) {
      return amount + this.amount;
    }
    if (type.equals("출금")) {
      return amount - this.amount;
    }
    if (type.equals("잔액")) {
      return this.amount;
    }
    return amount;
  }
}
