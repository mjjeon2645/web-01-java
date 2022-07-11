public class Transaction {

  private final String type;
  private final int amount;

  public Transaction(String type, int amount) {
    this.type = type;
    this.amount = amount;
  }

  public String type() {
    return this.type;
  }

  public int amount() {
    return this.amount;
  }

  public TransactionResult process(int amount) {
    return switch (this.type) {
      case "잔액" -> new TransactionResult(this, this.amount);
      case "출금" -> new TransactionResult(this, amount - this.amount);
      case "입금" -> new TransactionResult(this, amount + this.amount);
      default -> new TransactionResult(this, this.amount);
    };
  }

  @Override
  public boolean equals(Object other) {
    Transaction otherTransaction = (Transaction) other;

    return this.type.equals(otherTransaction.type)
        && this.amount == otherTransaction.amount;
  }

  @Override
  public String toString() {
    return "(Transaction) type: " + this.type + ", amount: " + this.amount;
  }
}
