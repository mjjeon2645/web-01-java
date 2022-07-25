import java.util.ArrayList;
import java.util.List;

public class Account {
  private String identifier = "SC제일은행 179-20-155318";
  private long amount = 5000;
  List<String> transactions = new ArrayList<>();

  public void transfer(long transferAmount) {
    this.amount -= transferAmount;

    transactions.add("송금: " + transferAmount + "원");
  }

  public String getIdentifier() {
    return this.identifier;
  }

  public long getAmount() {
    return this.amount;
  }

  public List<String> getTransactions() {
    return new ArrayList<>(transactions);
  }
}
