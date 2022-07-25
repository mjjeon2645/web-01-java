import java.util.ArrayList;
import java.util.List;

public class Account {
  private String AccountNumber = "123-2345-5543-34";
  private long amount = 1000;
  private List<String> transactions = new ArrayList<>();

  public long getAmount() {
    return this.amount;
  }

  public String getAccountNumber() {
    return AccountNumber;
  }

  public void transfer(long transferAmount) {
    amount -= transferAmount;

    transactions.add("송금:" + transferAmount + "원");
  }

  public List<String> transactions() {
    return new ArrayList<>(transactions);
  }

  public int transactionSize() {
    return transactions.size();
  }
}
