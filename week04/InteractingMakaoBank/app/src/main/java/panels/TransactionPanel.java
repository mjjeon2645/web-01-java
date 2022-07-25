package panels;

import models.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class TransactionPanel extends JPanel {
  public TransactionPanel(Account account1, Account account2)  {

    this.setLayout(new GridLayout(2,1));
    manageAccount1Panel(account1);
    manageAccount2Panel(account2);


  }
  private void manageAccount1Panel(Account account1) {
    JPanel account1Panel = new JPanel();
    account1Panel.setBorder(new MatteBorder(1,1,1,1,Color.BLACK));
    this.add(account1Panel);
    account1Panel.setLayout(new GridLayout(account1.getTransactions().size() + 2,1));

    JLabel accountNumberLabel = new JLabel("계좌 번호: " + account1.getAccountNumber());
    account1Panel.add(accountNumberLabel);
    JLabel amountLabel = new JLabel("잔액: " + account1.getCurrentAmount() + "원");
    account1Panel.add(amountLabel);

    for (String transaction : account1.getTransactions()) {
      JLabel transactionLabel = new JLabel(transaction);
      account1Panel.add(transactionLabel);
      System.out.println(transaction);
    }
  }
  private void manageAccount2Panel(Account account2) {
    JPanel account2Panel = new JPanel();
    account2Panel.setBorder(new MatteBorder(1,1,1,1,Color.BLACK));
    this.add(account2Panel);
    account2Panel.setLayout(new GridLayout(account2.getTransactions().size() + 2,1));

    JLabel accountNumberLabel = new JLabel("계좌 번호: " + account2.getAccountNumber());
    account2Panel.add(accountNumberLabel);
    JLabel amountLabel = new JLabel("잔액: " + account2.getCurrentAmount() + "원");
    account2Panel.add(amountLabel);

    for (String transaction : account2.getTransactions()) {
      JLabel transactionLabel = new JLabel(transaction);
      account2Panel.add(transactionLabel);
      System.out.println(transaction);
    }
  }
}


