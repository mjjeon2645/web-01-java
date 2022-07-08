package Panels;//내계좌 계좌번호 잔액을 보여줌
import models.*;

import javax.swing.*;
import java.awt.*;

public class AmountPanel extends JPanel {
  private Account myAccount;
  private Account yourAccount;

  public AmountPanel(Account myAccount, Account yourAccount) {
    this.myAccount = myAccount;
    this.yourAccount = yourAccount;

    this.setLayout(new GridLayout(2,1));

    manageMyAccountPanel();

    manageYourAccountPanel();

  }

  private void manageMyAccountPanel() {
    JPanel myAccountPanel = new JPanel();
    this.add(myAccountPanel);
    myAccountPanel.setLayout(new GridLayout(3,1));
    myAccountPanel.setBackground(Color.BLUE);

    JLabel label = new JLabel("내 계좌");
    myAccountPanel.add(label);

    JLabel accountNumberLabel = new JLabel("계좌 번호: " + myAccount.getAccountNumber());
    myAccountPanel.add(accountNumberLabel);

    JLabel amountLabel = new JLabel("잔액: " + myAccount.getCurrentAmount() + "원");
    myAccountPanel.add(amountLabel);
  }

  private void manageYourAccountPanel() {
    JPanel yourAccountPanel = new JPanel();
    this.add(yourAccountPanel);

    yourAccountPanel.setLayout(new GridLayout(3,1));
    yourAccountPanel.setBackground(Color.GREEN);

    JLabel label = new JLabel("상대 계좌");
    yourAccountPanel.add(label);

    JLabel accountNumberLabel = new JLabel("계좌 번호: " + yourAccount.getAccountNumber());
    yourAccountPanel.add(accountNumberLabel);

    JLabel amountLabel = new JLabel("잔액: " + yourAccount.getAmount() + "원");
    yourAccountPanel.add(amountLabel);
  }
}
