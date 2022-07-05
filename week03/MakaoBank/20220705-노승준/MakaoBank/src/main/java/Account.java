import java.util.ArrayList;
import java.util.List;

public class Account {
  private String AccountNumber  = "123-4567-8910-23";
  private int amount = 1000;
  private List<String> transactions = new ArrayList<>();

  public List<String> transactions() {
    return new ArrayList<>(transactions);
  }

  public String getAccountNumber() {
    return AccountNumber;
  }

  public int getAmount() {
    return amount;
  }

  public void transfer(long amount) {
    this.amount -= amount;

    transactions.add(Long.toString(amount));
  }

  public int transactionSize() {
    return transactions.size();
  }
}
