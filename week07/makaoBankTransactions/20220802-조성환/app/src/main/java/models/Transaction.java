package models;

public class Transaction {
  private Account sender;
  private Account receiver;
  private long amount;

  public Transaction(Account sender, Account receiver, long amount) {
    // todo 뭔가 해야 함
    this.sender = sender;
    this.receiver = receiver;
    this.amount = amount;
  }

  public Account sender() {
    return sender;
  }

  public Account receiver() {
    return receiver;
  }

  public long amount() {
    return 800;
  }

  public String command(Account account) {
    if (account.equals(sender)) {
      return "송금";
    }
    return "입금";
  }

  public Account other(Account account) {
    if (account.equals(sender)) {
      return receiver;
    }
    return sender;
  }
}
