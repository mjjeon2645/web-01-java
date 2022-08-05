package models;

public class Transaction {
  private final Account sender;
  private final Account receiver;
  private final long amount;

  public Transaction(Account sender, Account receiver, long amount) {
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
    return amount;
  }

  public String command(Account account) {
    if (sender.equals(account)) {
      return "송금";
    }

    return "입금";
  }

  public String name(Account account) {
    if (command(account).equals("송금")) {
      return receiver.name();
    }

    return sender.name();
  }
}
