package models;

import javax.swing.*;
import java.io.*;
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
    if (inputAccountNumber.equals(toAccount.getAccountNumber())) {
      this.amount -= transferAmount;
      transactions.add("계좌번호: " + toAccount.getAccountNumber() + "   "
          + "입금: " + transferAmount + "원");
    }
  }

  public void deposit(Account toAccount, int transferAmount, String inputAccountNumber) {
    if (inputAccountNumber.equals(toAccount.getAccountNumber())) {
      this.amount += transferAmount;
      transactions.add("계좌번호: " + toAccount.getAccountNumber() + "   "
          + "입금: " + transferAmount + "원");
    }
  }

  public List<String> getTransactions() {
    return new ArrayList<>(transactions);
  }

  public void loadfile() throws FileNotFoundException {
    File file = new File("input.csv");
    Scanner scanner = new Scanner(file);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String transactionRecord = parseTransaction(line);
      transactions.add(transactionRecord);
    }
  }

    private String parseTransaction(String text) {
    String[] words = text.split(",");
    String type = words[0];
    String amount = words[1];
    return type + ": " + amount + "원";
  }
}

