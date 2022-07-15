package panels;

import models.Account;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class AmountPanel extends JPanel {
  private Account myAccount;
  private Account otherAccount;

  private JPanel myAmountPanel;
  private JPanel otherAmountPanel;

  public AmountPanel(Account myAccount, Account otherAccount) {
    this.myAccount = myAccount;
    this.otherAccount = otherAccount;

    this.setLayout(new GridLayout(2, 1));

    initMyAmountArea();

    initOtherAmountArea();
  }

  public void initMyAmountArea() {
    myAmountPanel = new JPanel();
    myAmountPanel.setLayout(new GridLayout(3, 1, 30, 30));
    myAmountPanel.setBorder(new LineBorder(Color.BLACK, 3));

    JLabel titleLabel = new JLabel("내 계좌");
    myAmountPanel.add(titleLabel);

    JLabel identifierLabel = new JLabel("계좌 번호: " + myAccount.identifier());
    myAmountPanel.add(identifierLabel);

    JLabel amountLabel = new JLabel("잔액: " + myAccount.amount() + "원");
    myAmountPanel.add(amountLabel);

    this.add(myAmountPanel);
  }

  public void initOtherAmountArea() {
    otherAmountPanel = new JPanel();
    otherAmountPanel.setLayout(new GridLayout(3, 1, 30, 30));
    otherAmountPanel.setBorder(new LineBorder(Color.BLACK, 3));

    JLabel titleLabel = new JLabel("상대 계좌");
    otherAmountPanel.add(titleLabel);

    JLabel identifierLabel = new JLabel("계좌 번호: " + otherAccount.identifier());
    otherAmountPanel.add(identifierLabel);

    JLabel amountLabel = new JLabel("잔액: " + otherAccount.amount() + "원");
    otherAmountPanel.add(amountLabel);

    this.add(otherAmountPanel);
  }
}
