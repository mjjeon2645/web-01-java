public class Account {
  private String identifier;
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

  public void transfer(Account otherAccount, long transferAmount) {
    this.amount -= transferAmount;
    otherAccount.amount += transferAmount;
  }
}
