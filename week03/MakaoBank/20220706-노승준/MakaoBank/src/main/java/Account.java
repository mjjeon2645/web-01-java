import java.util.ArrayList;
import java.util.List;

public class Account {
  private String accountNumber = "123-4567-8910-12";
  private long amount = 1000;
  private List<String> transactions = new ArrayList<>();

  public String getAccountNumber() {
    return accountNumber;
  }

  public long getAmount() {
    return amount;
  }

  public List<String> getTransactions() {
    return new ArrayList<>(transactions);
  }

  public void transfer(long amount) {
    this.amount -= amount;

    transactions.add(Long.toString(amount));
  }

  public int transactionSize() {
    return transactions.size();
  }
}
