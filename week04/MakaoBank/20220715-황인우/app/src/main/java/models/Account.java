package models;

import java.util.ArrayList;
import java.util.List;

public class Account {
  private final String identifier;
  private long amount;
  private final List<String> transactions;

  public Account(String identifier, long amount, List<String> transactions) {
    this.identifier = identifier;
    this.amount = amount;
    this.transactions = transactions;
  }

  public String identifier() {
    return identifier;
  }

  public long amount() {
    return amount;
  }

  public List<String> transactions() {
    return new ArrayList<>(transactions);
  }

  public void transfer(Account otherAccount, long transferAmount) {
    this.amount -= transferAmount;
    otherAccount.amount += transferAmount;

    this.transactions.add("출금: " + transferAmount + "원");
    otherAccount.transactions.add("입금: " + transferAmount + "원");
  }
}
