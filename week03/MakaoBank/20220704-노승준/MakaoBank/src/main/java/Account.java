import java.util.ArrayList;
import java.util.List;

public class Account {
  private String number = "123-4567-8910-23";
  private long amount = 1000;
  private List<String> transactions = new ArrayList<>();

  public List<String> Transactions() {
    return new ArrayList<>(transactions);
  }

  public String getNumber() {
    return number;
  }

  public long getAmount() {
    return amount;
  }

  public void transfer(long amount) {
    this.amount -= amount;

    transactions.add("송금: " + amount + "원");
  }

  public int transactionSize() {
    return transactions.size();
  }
}
