package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheOtherAccount {
  private String identifier = "345-678-9012";
  private int amount = 3000;
  private List<String> theOtherTransactions = new ArrayList<>();

  public TheOtherAccount() throws FileNotFoundException {
    theOtherTransactions = loadTransactions();
  }

  public List<String> loadTransactions() throws FileNotFoundException {
    File file = new File("theothertransactions.csv");

    Scanner scanner = new Scanner(file);

    List<String> lists = new ArrayList<>();

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      lists.add(line);
    }
    return lists;
  }

  public String identifier() {
    return identifier;
  }

  public int amount() {
    return amount;
  }

  public List<String> theOtherTransactions() {
    return theOtherTransactions;
  }

  public void transfer(int transferAmount) {
    this.amount -= transferAmount;
    theOtherTransactions.add("출금," + transferAmount);
  }

  public void income(int transferAmount) {
    this.amount += transferAmount;
    theOtherTransactions.add("입금," + transferAmount);
  }
}
