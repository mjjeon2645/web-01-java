import java.util.ArrayList;
import java.util.List;

public class Account {
  private final String identifier = "352-0528-2645-53";
  private long amount = 5000;
  private final List<String> transactions = new ArrayList<>();

  public String getIdentifier() {
    return identifier;
  }

  public long getAmount() {
    return amount;
  }

  public List<String> getTransactions() {
    return new ArrayList<>(transactions);
  }

  public int transactionsSize() {
    return transactions.size();
  }

  public void transfer(long transferredAmount) {
    this.amount -= transferredAmount;
    this.transactions.add("송금: " + transferredAmount + "원");
  }
}
