package models;

import java.io.*;
import java.util.*;

public class Account {
  private String accountNumber;
  private int amount;
  private List<String> transactions = new ArrayList<>();
  private List<String> transactionsForCsv = new ArrayList<>();

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
      transactions.add("출금: " + transferAmount + "원");
      transactionsForCsv.add("출금," + transferAmount);
    }
  }

  public void deposit(Account toAccount, int transferAmount, String inputAccountNumber) {
    if (inputAccountNumber.equals(toAccount.getAccountNumber())) {
      this.amount += transferAmount;
      transactions.add("입금: " + transferAmount + "원");
      transactionsForCsv.add("입금," + transactionsForCsv);
    }
  }

  public List<String> getTransactions() {
    return new ArrayList<>(transactions);
  }

  public void loadFile() throws FileNotFoundException {
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

  public void saveFile() throws IOException {

    FileWriter fileWriter = new FileWriter("transaction.csv");

    for (String line : transactionsForCsv) {
      fileWriter.write(line + "\n");
    }
    fileWriter.close();
  }
}



