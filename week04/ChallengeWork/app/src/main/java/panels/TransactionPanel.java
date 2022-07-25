package panels;

import models.Account;

import javax.swing.*;
import java.awt.*;

public class TransactionPanel extends JPanel {
  private Account myAccount;
  private Account otherAccount;

  public TransactionPanel(Account myAccount, Account otherAccount) {
    this.myAccount = myAccount;
    this.otherAccount = otherAccount;

    this.setLayout(new GridLayout(2, 1));

    showMyTransactionPanel();
    otherTransactionPanel();
  }

  private void showMyTransactionPanel() {
    JPanel myTransactionPanel = new JPanel();
    this.add(myTransactionPanel);
    this.setLayout(new GridLayout(myAccount.transactionSize() + 2, 0));

    myTransactionPanel.add(new JLabel("잔액: " + myAccount.amount()));
    myTransactionPanel.add(new JLabel("계좌 번호: " + myAccount.identifier()));

    for (String transaction : myAccount.transactions()) {
      JLabel myTransactionLabel = new JLabel(transaction);
      myTransactionPanel.add(myTransactionLabel);
    }
  }

  private void otherTransactionPanel() {
    JPanel otherTransactionPanel = new JPanel();
    this.add(otherTransactionPanel);
    this.setLayout(new GridLayout(otherAccount.transactionSize() + 2, 0));

    otherTransactionPanel.add(new JLabel("잔액: " + otherAccount.amount()));
    otherTransactionPanel.add(new JLabel("계좌 번호: " + otherAccount.identifier()));

    for (String transaction : otherAccount.transactions()) {
      JLabel otherTransactionLabel = new JLabel(transaction);
      otherTransactionPanel.add(otherTransactionLabel);
    }
  }
}
