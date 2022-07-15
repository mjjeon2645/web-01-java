package panels;

import models.Account;

import javax.swing.*;
import java.awt.*;

public class TransactionPanel extends JPanel {
  private Account account;

  private JPanel myTransactionPanel;
  private JPanel otherTransactionPanel;

  public TransactionPanel(Account account) {
    this.account = account;

    this.setLayout(new GridLayout(2, 1));

    createMyTransactionPanel();
    myTransaction();

    createOtherTransactionPanel();
    otherTransaction();
  }

  public void createMyTransactionPanel() {
    myTransactionPanel = new JPanel();
    myTransactionPanel.setLayout(new GridLayout(0, 1));
    this.add(myTransactionPanel);
  }

  public void myTransaction() {
    myTransactionPanel.add(new JLabel("계좌번호: " +
        account.myAccountNumber()));

    for (String myTransaction : account.myTransactions) {
      JLabel myTransactionLabel = new JLabel(myTransaction);
      myTransactionPanel.add(myTransactionLabel);
    }
  }

  public void createOtherTransactionPanel() {
    otherTransactionPanel = new JPanel();
    otherTransactionPanel.setLayout(new GridLayout(0, 1));
    this.add(otherTransactionPanel);
  }

  public void otherTransaction() {
    otherTransactionPanel.add(new JLabel("계좌번호: " +
        account.otherAccountNumber()));

    for (String otherTransaction : account.otherTransactions) {
      JLabel otherTransactionLabel = new JLabel(otherTransaction);
      otherTransactionPanel.add(otherTransactionLabel);
    }
  }
}
