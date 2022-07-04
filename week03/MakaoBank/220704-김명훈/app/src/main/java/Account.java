import java.util.*;

public class Account {
  private long amount = 1000;
  private String identifier = "123-456-789";
  private List<String> transactions = new ArrayList<>();
  
  public long getAmount() {
    return amount;
  }
  
  public String getIdentifier() {
    return identifier;
  }
  
  public List<String> transactions() {
    return new ArrayList<>((transactions));
  }
  
  public int transactionSize() {
    return transactions.size();
  }
  
  public void transfer(long transferAmount) {
    amount -= transferAmount;

    transactions.add("송금: " + transferAmount + "원");
  }



}
