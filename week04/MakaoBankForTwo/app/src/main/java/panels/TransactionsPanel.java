package panels;

import models.MyAccount;
import models.TheOtherAccount;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TransactionsPanel extends JPanel {
  private MyAccount myAccount;
  private TheOtherAccount theOtherAccount;

  private JPanel myTransactionsPanel;
  private JPanel theOtherTransactionsPanel;

  public TransactionsPanel(MyAccount myAccount, TheOtherAccount theOtherAccount) {
    this.myAccount = myAccount;
    this.theOtherAccount = theOtherAccount;

    this.setLayout(new GridLayout(2, 1));

    initMyTransactionsArea();

    initTheOtherTransactionsArea();
  }

  public void initMyTransactionsArea() {
    myTransactionsPanel = new JPanel();
    myTransactionsPanel.setLayout(new GridLayout(0, 1, 30, 30));
    myTransactionsPanel.setBorder(new LineBorder(Color.BLACK, 3));

    JLabel identifierLabel = new JLabel("계좌 번호: " + myAccount.identifier());
    myTransactionsPanel.add(identifierLabel);

    JLabel amountLabel = new JLabel("잔액: 1000");
    myTransactionsPanel.add(amountLabel);

    for (String transaction : myAccount.myTransactions()) {
      String[] words = transaction.split(",");

      JLabel transactionLabel = new JLabel(words[0] + ": " + words[1] + "원");
      myTransactionsPanel.add(transactionLabel);
    }

    this.add(myTransactionsPanel);
  }

  public void initTheOtherTransactionsArea() {
    theOtherTransactionsPanel = new JPanel();
    theOtherTransactionsPanel.setLayout(new GridLayout(0, 1, 30, 30));
    theOtherTransactionsPanel.setBorder(new LineBorder(Color.BLACK, 3));

    JLabel identifierLabel = new JLabel("계좌 번호: " + theOtherAccount.identifier());
    theOtherTransactionsPanel.add(identifierLabel);

    JLabel amountLabel = new JLabel("잔액: 3000");
    theOtherTransactionsPanel.add(amountLabel);

    for (String transaction : theOtherAccount.theOtherTransactions()) {
      String[] words = transaction.split(",");

      JLabel transactionLabel = new JLabel(words[0] + ": " + words[1] + "원");
      theOtherTransactionsPanel.add(transactionLabel);
    }

    this.add(theOtherTransactionsPanel);
  }
}
