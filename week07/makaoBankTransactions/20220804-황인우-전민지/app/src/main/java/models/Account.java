package models;

import java.util.ArrayList;
import java.util.List;

public class Account {
  private List<Transaction> transactions = new ArrayList<>();

  private String identifier;
  private String name;
  private long amount;

  public Account(String identifier, String name, long amount) {
    this.identifier = identifier;
    this.name = name;
    this.amount = amount;
  }

  public String identifier() {
    return identifier;
  }

  public String name() {
    return name;
  }

  public long amount() {
    return amount;
  }

  public void transfer(Account receiver, long amount) {
    if (amount <= 0) {
      return;
    }

    this.amount -= amount;
    receiver.amount += amount;

    Transaction transaction = new Transaction(this, receiver, amount);
    this.transactions.add(transaction);
    receiver.transactions.add(transaction);
  }

  public List<Transaction> transactions() {
    return new ArrayList<>(transactions);
  }

  public int transactionsCount() {
    return transactions.size();
  }

  @Override
  public boolean equals(Object other) {
    Account otherAccount = (Account) other;
    return (this.identifier().equals(otherAccount.identifier()));
  }
}
