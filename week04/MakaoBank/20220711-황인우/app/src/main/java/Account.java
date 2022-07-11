import java.util.ArrayList;
import java.util.List;

public class Account {
  private int amount = 0;

  public List<TransactionResult> process(List<Transaction> transactions) {
    List<TransactionResult> transactionResults = new ArrayList<>();

    for (Transaction transaction : transactions) {
      TransactionResult transactionResult = transaction.process(this.amount);

      this.amount = transactionResult.result();

      transactionResults.add(transactionResult);
    }

    return transactionResults;
  }
}
