import java.util.ArrayList;
import java.util.List;

public class Account {
  private String myAccountNumber = "123-456-7890";
  private String counterpartAccountNumber = "345-678-9012";

  private long myAmount = 3000;
  private long counterpartAmount = 1000;

  private List<String> myTransactions = new ArrayList<>();
  private List<String> counterpartTransactions = new ArrayList<>();

  public long getMyAmount() {
    return myAmount;
  }

  public String getMyAccountNumber() {
    return myAccountNumber;
  }

  public long getCounterpartAmount() {
    return counterpartAmount;
  }

  public String getCounterpartAccountNumber() {
    return counterpartAccountNumber;
  }

  public List<String> myTransactions() {
    return new ArrayList<>(myTransactions);
  }

  public List<String> counterpartTransactions() {
    return new ArrayList<>(counterpartTransactions);
  }

  public int transactionSize() {
    return myTransactions.size();
  }

  public void transfer(long transferAmount, String accountNumber) {
    myAmount -= transferAmount;
    counterpartAmount += transferAmount;

    myTransactions.add("계좌번호:" + accountNumber +
        "      송금:" + transferAmount + "원");
    counterpartTransactions.add("계좌번호:" + getMyAccountNumber() +
        "      입금:" + transferAmount + "원");
  }

  public void deposit(long depositAmount, String accountNumber) {
    myAmount += depositAmount;
    counterpartAmount -= depositAmount;

    myTransactions.add("계좌번호:" + accountNumber +
        "      입금:" + depositAmount + "원");
    myTransactions.add("계좌번호:" + getCounterpartAccountNumber() +
        "      송금:" + depositAmount + "원");
  }
}
