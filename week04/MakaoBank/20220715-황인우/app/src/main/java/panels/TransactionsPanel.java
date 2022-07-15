package panels;

import models.Account;

import javax.swing.*;
import java.awt.*;

public class TransactionsPanel extends JPanel {
  public TransactionsPanel(Account myAccount, Account otherAccount) {
    this.setLayout(new GridLayout(0, 1));

    //내 계좌 거래 내역
    this.add(new JLabel("계좌 번호: " + myAccount.identifier()));

    for (String transaction : myAccount.transactions()) {
      this.add(new JLabel(transaction));
    }

    //상대 계좌 거래 내역
    this.add(new JLabel("계좌 번호: " + otherAccount.identifier()));

    for (String transaction : otherAccount.transactions()) {
      this.add(new JLabel(transaction));
    }
  }
}
