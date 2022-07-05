import java.util.ArrayList;
import java.util.List;

public class Account {
  private String accountNumber = "123-456-789";
  private long amount = 1000;
  private List<String> transactions = new ArrayList<>();

  public String getAccountNumber() {
    return accountNumber;
  }

  public long getAmount() {
    return amount;
  }

  public int transactionsSize() {
    return transactions.size();
  }

  public List<String> transactions() {
    return new ArrayList<>(transactions);
  }

  public void transfer(long transferAmount) {
    this.amount -= transferAmount;

    transactions.add("송금: " + transferAmount + "원");
  }
}
