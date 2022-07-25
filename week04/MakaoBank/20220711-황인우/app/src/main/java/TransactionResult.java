import java.lang.invoke.CallSite;

public class TransactionResult {
  private final Transaction transaction;
  private final int result;

  public TransactionResult(Transaction transaction, int result) {
    this.transaction = transaction;
    this.result = result;
  }

  public Transaction transaction() {
    return this.transaction;
  }

  public int result() {
    return this.result;
  }

  @Override
  public boolean equals(Object other) {
    TransactionResult otherTransactionResult = (TransactionResult) other;

    return this.transaction.equals(otherTransactionResult.transaction)
        && this.result == otherTransactionResult.result;
  }

  @Override
  public String toString() {
    return "(TransactionResult) (" + this.transaction.toString()
        + ", result: " + this.result + ")";
  }
}
