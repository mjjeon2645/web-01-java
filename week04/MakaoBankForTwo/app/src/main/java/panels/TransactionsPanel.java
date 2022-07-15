package panels;

import models.Account;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TransactionsPanel extends JPanel {
  private Account myAccount;
  private Account otherAccount;

  private JPanel myTransactionsPanel;
  private JPanel otherTransactionsPanel;

  public TransactionsPanel(Account myAccount, Account otherAccount) {
    this.myAccount = myAccount;
    this.otherAccount = otherAccount;

    this.setLayout(new GridLayout(2, 1));

    initMyTransactionsArea();

    initOtherTransactionsArea();
  }

  public void initMyTransactionsArea() {
    myTransactionsPanel = new JPanel();
    myTransactionsPanel.setLayout(new GridLayout(0, 1, 30, 30));
    myTransactionsPanel.setBorder(new LineBorder(Color.BLACK, 3));

    JLabel identifierLabel = new JLabel("계좌 번호: " + myAccount.identifier());
    myTransactionsPanel.add(identifierLabel);

    JLabel amountLabel = new JLabel("잔액: " + 1000);
    myTransactionsPanel.add(amountLabel);

    for (String transaction : myAccount.transactions()) {
      String[] words = transaction.split(",");

      JLabel transactionLabel = new JLabel(words[0] + ": " + words[1] + "원");
      myTransactionsPanel.add(transactionLabel);
    }

    this.add(myTransactionsPanel);
  }

  public void initOtherTransactionsArea() {
    otherTransactionsPanel = new JPanel();
    otherTransactionsPanel.setLayout(new GridLayout(0, 1, 30, 30));
    otherTransactionsPanel.setBorder(new LineBorder(Color.BLACK, 3));

    JLabel identifierLabel = new JLabel("계좌 번호: " + otherAccount.identifier());
    otherTransactionsPanel.add(identifierLabel);

    JLabel amountLabel = new JLabel("잔액: " + 3000);
    otherTransactionsPanel.add(amountLabel);

    for (String transaction : otherAccount.transactions()) {
      String[] words = transaction.split(",");

      JLabel transactionLabel = new JLabel(words[0] + ": " + words[1] + "원");
      otherTransactionsPanel.add(transactionLabel);
    }

    this.add(otherTransactionsPanel);
  }
}
