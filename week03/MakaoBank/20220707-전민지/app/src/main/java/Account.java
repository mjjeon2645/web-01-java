import java.util.ArrayList;
import java.util.List;

public class Account {
  private String accountNumber = "1234-567-890";
  private long amount = 1000;
  private List<String> transactions = new ArrayList<>();

  public String getAccountNumber() {
    return accountNumber;
  }

  public long getAmount() {
    return amount;
  }

  public List<String> transactions() {
    return new ArrayList<>(transactions);
  }

  public void transfer(long amount) {
    this.amount -= amount;

    transactions.add("송금: " + amount + "원");
  }
}
