package models;

import java.util.List;

public class Account {
  private final String identifier;
  private final List<String> transactions;
  private int amount;

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

  public int transactionSize() {
    return transactions.size();
  }
  public List<String> transactions() {
    return transactions;
  }

  public void transfer(Account myAccount, Account otherAccount,
                       String identifier, int sendAmount) {
    if (identifier.equals(otherAccount.identifier)) {
      myAccount.amount -= sendAmount;
      otherAccount.amount += sendAmount;

      myAccount.transactions.add("송금: " + sendAmount + "원");
      otherAccount.transactions.add("입금: " + sendAmount + "원");
    }

    if (identifier.equals(myAccount.identifier)){
      otherAccount.amount -= sendAmount;
      myAccount.amount += sendAmount;

      myAccount.transactions.add("입금: " + sendAmount + "원");
      otherAccount.transactions.add("송금: " + sendAmount + "원");
    }
  }
}
