import java.util.ArrayList;
import java.util.List;

public class Account {
  private String myAccountIdentifier = "123-456-7890";
  private String otherAccountIdentifier = "345-678-9012";
  private long myAccountAmount = 3000;
  private long otherAccountAmount = 1000;
  private List<String> transactions = new ArrayList<>();

  public String myAccountIdentifier() {
    return myAccountIdentifier;
  }

  public String otherAccountIdentifier() {
    return otherAccountIdentifier;
  }

  public long myAccountAmount() {
    return myAccountAmount;
  }

  public long otherAccountAmount() {
    return otherAccountAmount;
  }

  public int transactionSize() {
    return transactions.size();
  }

  public List<String> transactions() {
    return new ArrayList<>(transactions);
  }

  public void transfer(String accountNumber, long amount) {
    if (accountNumber.equals(otherAccountIdentifier)) {
      myAccountAmount -= amount;
      otherAccountAmount += amount;

      transactions.add("계좌 번호: " + myAccountIdentifier + "\t송금: " + amount);
    }
  }

  public void deposit(String depositAccountNumber, long amount) {
    if (depositAccountNumber.equals(myAccountIdentifier)) {
      myAccountAmount += amount;
      otherAccountAmount -= amount;

      transactions.add("계좌 번호: " + myAccountIdentifier + "\t입금: " + amount);
    }
  }
}
