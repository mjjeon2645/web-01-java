package panels;

import models.Account;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TransferPanel extends JPanel {
  private Account myAccount;
  private Account otherAccount;

  private JPanel myTransferPanel;
  private JPanel otherTransferPanel;

  public TransferPanel(Account myAccount, Account otherAccount) {
    this.myAccount = myAccount;
    this.otherAccount = otherAccount;

    this.setLayout(new GridLayout(2, 1));

    initMyTransferArea();

    initOtherTransferArea();
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
      if (identifierTextField.getText().equals(otherAccount.identifier())) {
        int amount = Integer.parseInt(amountTextField.getText());
        myAccount.transfer(otherAccount, amount);
      }
    });
    myTransferPanel.add(transferButton);

    this.add(myTransferPanel);
  }

  public void initOtherTransferArea() {
    otherTransferPanel = new JPanel();
    otherTransferPanel.setLayout(new GridLayout(4, 2, 30, 30));
    otherTransferPanel.setBorder(new LineBorder(Color.BLACK, 3));

    JLabel titleLabel = new JLabel("계좌 번호: " + otherAccount.identifier());
    otherTransferPanel.add(titleLabel);

    JLabel layoutLabel1 = new JLabel("     ");
    otherTransferPanel.add(layoutLabel1);

    JLabel toLabel = new JLabel("보낼 계좌 번호: ");
    otherTransferPanel.add(toLabel);

    JTextField identifierTextField = new JTextField(10);
    otherTransferPanel.add(identifierTextField);

    JLabel transferAmountLabel = new JLabel("이체할 금액: ");
    otherTransferPanel.add(transferAmountLabel);

    JTextField amountTextField = new JTextField(10);
    otherTransferPanel.add(amountTextField);

    JLabel layoutLabel2 = new JLabel("     ");
    otherTransferPanel.add(layoutLabel2);

    JButton transferButton = new JButton("송금");
    transferButton.addActionListener(event -> {
      if (identifierTextField.getText().equals(myAccount.identifier())) {
        int amount = Integer.parseInt(amountTextField.getText());
        otherAccount.transfer(myAccount, amount);
      }
    });
    otherTransferPanel.add(transferButton);

    this.add(otherTransferPanel);
  }
}
