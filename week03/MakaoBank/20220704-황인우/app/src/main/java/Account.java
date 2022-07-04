import java.util.ArrayList;
import java.util.List;

public class Account {
  private final String identifier = "352-0528-2645-53";
  private long amount = 5000;
  private List<String> transactions = new ArrayList<>();

  public String identifier() {
    return this.identifier;
  }

  public long amount() {
    return this.amount;
  }

  public void transfer(long transferredAmount) {
    this.amount -= transferredAmount;
    this.transactions.add("송금: " + transferredAmount + "원");
  }

  public List<String> transactions() {
    return new ArrayList<>(transactions);
  }
}
