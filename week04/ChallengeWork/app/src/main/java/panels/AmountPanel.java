package panels;

import models.Account;

import javax.swing.*;
import java.awt.*;

public class AmountPanel extends JPanel {
  private Account myAccount;
  private Account otherAccount;

  public AmountPanel(Account myAccount, Account otherAccount) {
    this.myAccount = myAccount;
    this.otherAccount = otherAccount;

    this.setLayout(new GridLayout(2, 1));

    showMyAccountPanel();
    showOtherAccountPanel();
  }

  private void showMyAccountPanel() {
    JPanel myAccountpanel = new JPanel();
    this.add(myAccountpanel);

    myAccountpanel.setLayout(new GridLayout(2, 1));

    myAccountpanel.add(new JLabel("계좌 번호: " + myAccount.identifier()));
    myAccountpanel.add(new JLabel("잔액: " + myAccount.amount()));
  }

  private void showOtherAccountPanel() {
    JPanel otherAccountPanel = new JPanel();
    this.add(otherAccountPanel);

    otherAccountPanel.setLayout(new GridLayout(2, 1));

    otherAccountPanel.add(new JLabel("계좌 번호: " + otherAccount.identifier()));
    otherAccountPanel.add(new JLabel("잔액: " + otherAccount.amount()));
  }


}
