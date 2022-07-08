package Panels;

import models.*;

import javax.swing.*;
import java.awt.*;

public class TransactionPanel extends JPanel {
  public TransactionPanel(Account myAccount, Account yourAccount) {

    this.setLayout(new GridLayout(myAccount.getTransactions().size() + 1,1));

    JLabel titleLabel = new JLabel("거래 내역");
    this.add(titleLabel);

    for (String transaction : myAccount.getTransactions()) {
      JLabel transactionLabel = new JLabel(transaction);
      this.add(transactionLabel);
      System.out.println(transaction);
    }

  }
}
