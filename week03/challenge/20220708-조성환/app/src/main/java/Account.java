
import java.util.ArrayList;
import java.util.List;

public class Account {
  private String myAccountNumber = "123-456-7890";
  private String otherAccountNumber = "345-678-9012";
  private long myAccountAmount = 3000L;
  private long otherAccountAmount = 1000L;
  private List<String> transactions = new ArrayList<>();

  public String myAccountNumber() {
    return myAccountNumber;
  }

  public String otherAccountNumber() {
    return otherAccountNumber;
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
    if (accountNumber.equals(otherAccountNumber)) {
      myAccountAmount -= amount;
      otherAccountAmount += amount;

      transactions.add("계좌 번호: " + myAccountNumber + "\t송금: " + amount);
    }

  }

  public void deposit(String depositAccountNumber, long amount) {
    if (depositAccountNumber.equals(myAccountNumber)) {
      myAccountAmount += amount;
      otherAccountAmount -= amount;

      transactions.add("계좌 번호: " + myAccountNumber + "\t입금: " + amount);
    }

  }
}
