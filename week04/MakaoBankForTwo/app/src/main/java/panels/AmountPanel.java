package panels;

import models.MyAccount;
import models.TheOtherAccount;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class AmountPanel extends JPanel {
  private MyAccount myAccount;
  private TheOtherAccount theOtherAccount;

  private JPanel myAmountPanel;
  private JPanel theOtherAmountPanel;

  public AmountPanel(MyAccount myAccount, TheOtherAccount theOtherAccount) {
    this.myAccount = myAccount;
    this.theOtherAccount = theOtherAccount;

    this.setLayout(new GridLayout(2, 1));

    initMyAmountArea();

    initTheOtherAmountArea();
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

  public void initTheOtherAmountArea() {
    theOtherAmountPanel = new JPanel();
    theOtherAmountPanel.setLayout(new GridLayout(3, 1, 30, 30));
    theOtherAmountPanel.setBorder(new LineBorder(Color.BLACK, 3));

    JLabel titleLabel = new JLabel("상대 계좌");
    theOtherAmountPanel.add(titleLabel);

    JLabel identifierLabel = new JLabel("계좌 번호: " + theOtherAccount.identifier());
    theOtherAmountPanel.add(identifierLabel);

    JLabel amountLabel = new JLabel("잔액: " + theOtherAccount.amount() + "원");
    theOtherAmountPanel.add(amountLabel);

    this.add(theOtherAmountPanel);
  }
}
