package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyAccount {
  private String identifier = "123-456-7890";
  private int amount = 1000;
  private List<String> myTransactions = new ArrayList<>();

  public MyAccount() throws FileNotFoundException {
    myTransactions = loadTransactions();
  }

  public List<String> loadTransactions() throws FileNotFoundException {
    File file = new File("mytransactions.csv");

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

  public List<String> myTransactions() {
    return myTransactions;
  }

  public void income(int transferAmount) {
    myTransactions.add("입금," + transferAmount);
    this.amount += transferAmount;
  }

  public void transfer(int transferAmount) {
    myTransactions.add("출금," + transferAmount);
    this.amount -= transferAmount;
  }
}
