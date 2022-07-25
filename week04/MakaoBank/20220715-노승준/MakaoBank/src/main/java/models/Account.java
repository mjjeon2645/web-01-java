package models;

import java.util.ArrayList;
import java.util.List;

public class Account {
  private String myAccountNumber = "123-456-7890";
  private String otherAccountNumber = "345-678-9012";

  private int myAmount = 1000;
  private int otherAmount = 3000;

  public List<String> myTransactions = new ArrayList<>();
  public List<String> otherTransactions = new ArrayList<>();

  public int myAmount() {
    return myAmount;
  }

  public String myAccountNumber() {
    return myAccountNumber;
  }

  public String otherAccountNumber() {
    return otherAccountNumber;
  }

  public int otherAmount() {
    return otherAmount;
  }

  public void myTransfer(int amount) {
    this.myAmount -= amount;
    this.otherAmount += amount;

    myTransactions.add("출금 :" + amount + "원");
    otherTransactions.add("입금 :" + amount + "원");
  }

  public void otherTransfer(int amount) {
    this.otherAmount -= amount;
    this.myAmount += amount;

    myTransactions.add("입금 :" + amount + "원");
    otherTransactions.add("출금 :" + amount + "원");
  }
}
