package panels;

import models.MyAccount;
import models.TheOtherAccount;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TransferPanel extends JPanel {
  private MyAccount myAccount;
  private TheOtherAccount theOtherAccount;

  private JPanel myTransferPanel;
  private JPanel theOtherTransferPanel;

  public TransferPanel(MyAccount myAccount, TheOtherAccount theOtherAccount) {
    this.myAccount = myAccount;
    this.theOtherAccount = theOtherAccount;

    this.setLayout(new GridLayout(2, 1));

    initMyTransferArea();

    initTheOtherTransferArea();
  }

  public void initMyTransferArea() {
    myTransferPanel = new JPanel();
    myTransferPanel.setLayout(new GridLayout(4, 2, 30, 30));
    myTransferPanel.setBorder(new LineBorder(Color.BLACK, 3));

    JLabel identifierLabel = new JLabel("계좌 번호: " + myAccount.identifier());
    myTransferPanel.add(identifierLabel);

    JLabel layoutLabel1 = new JLabel("     ");
    myTransferPanel.add(layoutLabel1);

    JLabel toLabel = new JLabel("보낼 계좌 번호: ");
    myTransferPanel.add(toLabel);

    JTextField identifierTextField = new JTextField(10);
    myTransferPanel.add(identifierTextField);

    JLabel transferAmountLabel = new JLabel("이체할 금액: ");
    myTransferPanel.add(transferAmountLabel);

    JTextField amountTextField = new JTextField(10);
    myTransferPanel.add(amountTextField);

    JLabel layoutLabel2 = new JLabel("     ");
    myTransferPanel.add(layoutLabel2);

    JButton transferButton = new JButton("송금");
    transferButton.addActionListener(event -> {
      if (identifierTextField.getText().equals(theOtherAccount.identifier())) {
        int transferAmount = Integer.parseInt(amountTextField.getText());
        myAccount.transfer(transferAmount);
        theOtherAccount.income(transferAmount);
      }
    });
    myTransferPanel.add(transferButton);

    this.add(myTransferPanel);
  }

  public void initTheOtherTransferArea() {
    theOtherTransferPanel = new JPanel();
    theOtherTransferPanel.setLayout(new GridLayout(4, 2, 30, 30));
    theOtherTransferPanel.setBorder(new LineBorder(Color.BLACK, 3));

    JLabel titleLabel = new JLabel("계좌 번호: " + theOtherAccount.identifier());
    theOtherTransferPanel.add(titleLabel);

    JLabel layoutLabel1 = new JLabel("     ");
    theOtherTransferPanel.add(layoutLabel1);

    JLabel toLabel = new JLabel("보낼 계좌 번호: ");
    theOtherTransferPanel.add(toLabel);

    JTextField identifierTextField = new JTextField(10);
    theOtherTransferPanel.add(identifierTextField);

    JLabel transferAmountLabel = new JLabel("이체할 금액: ");
    theOtherTransferPanel.add(transferAmountLabel);

    JTextField amountTextField = new JTextField(10);
    theOtherTransferPanel.add(amountTextField);

    JLabel layoutLabel2 = new JLabel("     ");
    theOtherTransferPanel.add(layoutLabel2);

    JButton transferButton = new JButton("송금");
    transferButton.addActionListener(event -> {
      if (identifierTextField.getText().equals(myAccount.identifier())) {
        int transferAmount = Integer.parseInt(amountTextField.getText());
        theOtherAccount.transfer(transferAmount);
        myAccount.income(transferAmount);
      }
    });
    theOtherTransferPanel.add(transferButton);

    this.add(theOtherTransferPanel);
  }
}
