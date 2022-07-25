import java.util.ArrayList;
import java.util.List;

public class Account {
  private final String identifier;
  private final List<String> transactions = new ArrayList<>();
  private long amount;

  public Account(String identifier, long amount) {
    this.identifier = identifier;
    this.amount = amount;
  }

  public String identifier() {
    return this.identifier;
  }

  public long amount() {
    return this.amount;
  }

  public List<String> transactions() {
    return new ArrayList<>(transactions);
  }

  public void transfer(Account otherAccount, long transferAmount) {
    this.amount -= transferAmount;
    this.transactions.add(
        "계좌 번호: " + this.identifier
            + "   송금: " + transferAmount
    );

    otherAccount.amount += transferAmount;
    otherAccount.transactions.add(
        "계좌 번호: " + otherAccount.identifier
            + "   입금: " + transferAmount
    );
  }
}
