package models;

import java.util.List;

public class Account {
  private String identifier;
  private int amount;
  private List<String> transactions;

  public Account(String identifier, int amount, List<String> transactions) {
    this.identifier = identifier;
    this.amount = amount;
    this.transactions = transactions;
  }

  public String identifier() {
    return identifier;
  }

  public int amount() {
    return amount;
  }

  public List<String> transactions() {
    return transactions;
  }

  public void transfer(Account otherAccount, int amount) {
    this.amount -= amount;
    this.transactions.add("출금," + amount);

    otherAccount.amount += amount;
    otherAccount.transactions.add("입금," + amount);
  }
}
