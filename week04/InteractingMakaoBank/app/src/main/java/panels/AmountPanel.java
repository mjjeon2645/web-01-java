package panels;

import models.*;

import javax.swing.*;
import java.awt.*;

public class AmountPanel extends JPanel {
  private Account account1;
  private Account account2;

  public AmountPanel(Account account1, Account account2) {
    this.account1 = account1;
    this.account2 = account2;

    this.setLayout(new GridLayout(2,1));
    manageAccount1Panel();
    manageAccount2Panel();
  }
  private void manageAccount1Panel() {
    JPanel account1Panel = new JPanel();
    this.add(account1Panel);
    account1Panel.setLayout(new GridLayout(3,1));
    account1Panel.setBackground(Color.BLUE);
    JLabel label = new JLabel("내 계좌");
    account1Panel.add(label);
    JLabel accountNumberLabel = new JLabel("계좌 번호: " + account1.getAccountNumber());
    account1Panel.add(accountNumberLabel);
    JLabel amountLabel = new JLabel("잔액: " + account1.getCurrentAmount() + "원");
    account1Panel.add(amountLabel);
  }
  private void manageAccount2Panel() {
    JPanel account2Panel = new JPanel();
    this.add(account2Panel);
    account2Panel.setLayout(new GridLayout(3,1));
    account2Panel.setBackground(Color.GREEN);
    JLabel label = new JLabel("상대 계좌");
    account2Panel.add(label);
    JLabel accountNumberLabel = new JLabel("계좌 번호: " + account2.getAccountNumber());
    account2Panel.add(accountNumberLabel);

    JLabel amountLabel = new JLabel("잔액: " + account2.getCurrentAmount() + "원");
    account2Panel.add(amountLabel);
  }
}