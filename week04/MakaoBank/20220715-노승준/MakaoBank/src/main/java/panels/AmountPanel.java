package panels;

import models.Account;

import javax.swing.*;
import java.awt.*;

public class AmountPanel extends JPanel {
  private Account account;

  public AmountPanel(Account account) {
    this.account = account;
    this.setLayout(new GridLayout(2, 1));

    this.add(new JLabel("계좌번호: " + account.myAccountNumber() + "\t"));
    this.add(new JLabel("잔액: " + account.myAmount()));

    this.add(new JLabel("계좌번호: " + account.otherAccountNumber() + "\t"));
    this.add(new JLabel("잔액: " + account.otherAmount()));
  }
}
