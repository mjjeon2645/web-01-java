import java.util.ArrayList;
import java.util.List;

public class Account {
  private final String identifier = "110-384-622540";
  private long amount = 1000;
  private final List<String> transactions = new ArrayList<>();

  public String identifier() {
    return this.identifier;
  }

  public long amount() {
    return this.amount;
  }

  public List<String> transactions() {
    return new ArrayList<>(transactions);
  }

  public void transfer(long amount) {
    this.amount -= amount;

    transactions.add("송금: " + amount + "원");
  }
}
