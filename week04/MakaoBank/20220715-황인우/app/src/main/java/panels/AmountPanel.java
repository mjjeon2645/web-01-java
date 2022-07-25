package panels;

import models.Account;

import javax.swing.*;
import java.awt.*;

public class AmountPanel extends JPanel {
  public AmountPanel(Account myAccount, Account otherAccount) {
    this.setLayout(new GridLayout(0, 1));

    this.add(new JLabel("계좌 번호: " + myAccount.identifier()));
    this.add(new JLabel("잔액: " + myAccount.amount()));

    this.add(new JLabel("계좌 번호: " + otherAccount.identifier()));
    this.add(new JLabel("잔액: " + otherAccount.amount()));
  }
}
