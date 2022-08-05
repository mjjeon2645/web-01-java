package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Account {
  private String identifier;
  private String name;
  private long amount;
  private List<Transaction> transactions = new ArrayList<>();

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
    if (amount < 0) {
      return;
    }
    this.amount -= amount;

    receiver.amount += amount;

    Transaction transaction = new Transaction(this, receiver, amount);
    transactions.add(transaction);
    receiver.transactions.add(transaction);
  }

  public int transactionCount() {
    return transactions.size();
  }

  public List<Transaction> transactions() {
    return new ArrayList<>(transactions);
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object other) {
    Account otherAccount = (Account) other;
    return identifier.equals(otherAccount.identifier);
  }
}
