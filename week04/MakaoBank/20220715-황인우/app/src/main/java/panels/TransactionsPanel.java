package panels;

import models.Account;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionsPanel extends JPanel {
  public TransactionsPanel(Account myAccount, Account otherAccount) {
    this.setLayout(new GridLayout(0, 1));

    //내 계좌 거래 내역
    JLabel myIdentifierLabel = new JLabel("계좌 번호: " + myAccount.identifier());
    List<JLabel> myTransactionLabels = new ArrayList<>();

    long myOriginalAmount = myAccount.amount();

    for (String transaction : myAccount.transactions()) {
      myTransactionLabels.add(new JLabel(transaction));

      long transferAmount = Long.parseLong(transaction.replaceAll("\\D", ""));
      transferAmount *= transaction.contains("출금") ? 1 : -1;

      myOriginalAmount += transferAmount;
    }

    JLabel myOriginalAmountLabel = new JLabel("잔액: " + myOriginalAmount);

    this.add(myIdentifierLabel);
    this.add(myOriginalAmountLabel);

    for (JLabel transactionLabel : myTransactionLabels) {
      this.add(transactionLabel);
    }

    //상대 계좌 거래 내역
    JLabel otherIdentifierLabel = new JLabel("계좌 번호: " + otherAccount.identifier());
    List<JLabel> otherTransactionLabels = new ArrayList<>();

    long otherOriginalAmount = otherAccount.amount();

    for (String transaction : otherAccount.transactions()) {
      otherTransactionLabels.add(new JLabel(transaction));

      long transferAmount = Long.parseLong(transaction.replaceAll("\\D", ""));
      transferAmount *= transaction.contains("출금") ? 1 : -1;

      otherOriginalAmount += transferAmount;
    }

    JLabel otherOriginalAmountLabel = new JLabel("잔액: " + otherOriginalAmount);

    this.add(otherIdentifierLabel);
    this.add(otherOriginalAmountLabel);

    for (JLabel transactionLabel : otherTransactionLabels) {
      this.add(transactionLabel);
    }
  }
}
