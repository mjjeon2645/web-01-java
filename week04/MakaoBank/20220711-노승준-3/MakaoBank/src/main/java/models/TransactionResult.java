// 거래 내역 참조, 잔액만 들고 있게하기

package models;

public class TransactionResult {

  private Transaction transaction;
  private int amount;

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
    TransactionResult otherTransactionResult = (TransactionResult) other;
    return this.transaction == otherTransactionResult.transaction &&
        this.amount == otherTransactionResult.amount;
  }

  @Override
  public String toString() {
    return "TransactionResult(" + transaction + ", 잔액: " + amount + ")";
  }

  public String toCsvRow() {
    return String.join(",",values());
  }
}
