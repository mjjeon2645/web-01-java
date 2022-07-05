import java.util.ArrayList;
import java.util.List;

public class Account {
  private String identifier = "1234-5678-90";
  private long amount = 1000;
  private List<String> transactions = new ArrayList<>();

  public long getAmount() {
    return amount;
  }

  public String getIdentifier() {
    return identifier;
  }

  public int TransactionsSize() {
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
