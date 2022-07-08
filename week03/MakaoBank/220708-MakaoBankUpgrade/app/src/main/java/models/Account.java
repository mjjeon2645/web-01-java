package models;

public class Account {
  private String accountNumber;
  private int amount;



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


}
