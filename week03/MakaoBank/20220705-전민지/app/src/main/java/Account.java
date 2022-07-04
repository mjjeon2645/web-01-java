import java.util.ArrayList;
import java.util.List;

public class Account {
  private long amount = 1000;
  private String identifier = "123-456-789";
  private List<String> transactions = new ArrayList<>();

  public long getAmount() {
    return this.amount;
  }

  public String getIdentifier() {
    return identifier;
  }

  public List<String> transactions() {
    return new ArrayList<>(transactions);
  }

  public int transactionsSize() {
    return transactions.size();
  }

  public void transfer(long amount) {
    this.amount -= amount;

    transactions = new ArrayList<>();
    transactions.add("송금: " + amount + "원");
  }
}
