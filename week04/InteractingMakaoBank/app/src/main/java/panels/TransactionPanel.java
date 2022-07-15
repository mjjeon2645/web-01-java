package panels;

import models.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class TransactionPanel extends JPanel {
  public TransactionPanel(Account account1, Account account2)  {

    this.setLayout(new GridLayout(account1.getTransactions().size() + 1,1));

    JLabel titleLabel = new JLabel("거래 내역");
    this.add(titleLabel);

    for (String transaction : account1.getTransactions()) {
      JLabel transactionLabel = new JLabel(transaction);
      this.add(transactionLabel);
      System.out.println(transaction);
    }
  }


}


