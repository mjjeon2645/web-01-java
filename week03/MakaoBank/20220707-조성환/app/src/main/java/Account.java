import java.util.ArrayList;
import java.util.List;

public class Account {
  private long amount = 1000;
  private String identifier = "1234-5678-90-12";
  private List<String> transactions = new ArrayList<>();

  public long amount() {
    return amount;
  }

  public String identifier() {
    return identifier;
  }

  public int transactionSize() {
    return transactions.size();
  }

  public List<String> transactions() {
    return new ArrayList<>(transactions);
  }

  public void transfer(long transferAmount) {
    amount -= transferAmount;

    transactions.add("송금 " + transferAmount + "원");
  }
}
