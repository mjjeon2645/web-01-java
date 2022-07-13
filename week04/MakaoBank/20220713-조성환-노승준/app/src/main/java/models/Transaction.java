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

  @Override
  public String toString() {
    return "Transaction(" + type + "," + amount + ")";
  }

  public String type() {
    return type;
  }

  public Integer amount() {
    return amount;
  }

  public int process(int amount) {
    if (this.type.equals("잔액")) {
      return this.amount;
    }
    if (this.type.equals("입금")) {
      return this.amount + amount;
    }
    if (this.type.equals("출금")) {
      return amount - this.amount;
    }

    return amount;
  }
}
