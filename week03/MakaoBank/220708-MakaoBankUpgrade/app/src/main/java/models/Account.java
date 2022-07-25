package models;

import java.util.*;

public class Account {
  private String accountNumber;
  private int amount;
  private List<String> transactions = new ArrayList<>();


public Account(String accountNumber, int amount) {
 this.accountNumber = accountNumber;
 this.amount = amount;
}

public String getAccountNumber() {
  return accountNumber;
}

public int getCurrentAmount() {
    return this.amount;
  }


  public void transfer(Account toAccount, int transferAmount, String inputAccountNumber) {
  if(inputAccountNumber.equals(toAccount.getAccountNumber())) {
    this.amount -= transferAmount;
    transactions.add("계좌번호: " + toAccount.getAccountNumber() + "   "
        + "입금: " + transferAmount + "원");
          }
  }

  public void deposit(Account toAccount, int transferAmount, String inputAccountNumber) {
    if(inputAccountNumber.equals(toAccount.getAccountNumber())) {
      this.amount += transferAmount;
      transactions.add("계좌번호: " + toAccount.getAccountNumber() + "   "
          + "입금: " + transferAmount + "원");
    }
  }

  public List<String> getTransactions() {
  return new ArrayList<>(transactions);
  }
}
