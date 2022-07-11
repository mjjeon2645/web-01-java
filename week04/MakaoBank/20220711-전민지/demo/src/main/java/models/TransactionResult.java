// 얘가 뭐냐! -> 거래 내역과 잔액을 들고 있게 한다. (선택 안함)
//          -> 또는 거래 내역을 *참조* 하고 잔액만 들고 있는다. (선택!)

package models;

public class TransactionResult {
  private final Transaction transaction;
  private final int amount;

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
  public String toString() {
    return "TransactionResult(" + transaction.toString() + ", 잔액: " + amount + ")";
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object other) {
    TransactionResult otherTransactionResult = (TransactionResult) other;
    return this.transaction == otherTransactionResult.transaction
        && this.amount == otherTransactionResult.amount;
  }

  public String toCsvRow() {
    return String.join(",", values());
  }
}
