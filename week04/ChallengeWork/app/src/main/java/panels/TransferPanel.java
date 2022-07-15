package panels;

import models.Account;

import javax.swing.*;
import java.awt.*;

public class TransferPanel extends JPanel {
  private Account myAccount;
  private Account otherAccount;

  public TransferPanel(Account myAccount, Account otherAccount) {
    this.myAccount = myAccount;
    this.otherAccount = otherAccount;

    this.setLayout(new GridLayout(0, 1));

    showMyTransferPanel();
    showOtherTransferPanel();
  }

  private void showMyTransferPanel() {
    JPanel myTransferPaenl = new JPanel();
    this.add(myTransferPaenl);

    myTransferPaenl.setLayout(new GridLayout(6, 1));

    myTransferPaenl.add(new JLabel("계좌 번호: " + myAccount.identifier()));

    myTransferPaenl.add(new JLabel("보낼 계좌 번호"));
    JTextField accountInputField = new JTextField(10);
    myTransferPaenl.add(accountInputField);

    myTransferPaenl.add(new JLabel("보낼 금액"));
    JTextField amountInputField = new JTextField(10);
    myTransferPaenl.add(amountInputField);

    JButton button = new JButton("송금");
    button.addActionListener(event -> {
      String identifier = accountInputField.getText();
      int sendAmount = Integer.parseInt(amountInputField.getText());
      myAccount.transfer(myAccount, otherAccount, identifier, sendAmount);
    });
    myTransferPaenl.add(button);
  }

  private void showOtherTransferPanel() {
    JPanel otherTransferPaenl = new JPanel();
    this.add(otherTransferPaenl);

    otherTransferPaenl.setLayout(new GridLayout(6, 1));

    otherTransferPaenl.add(new JLabel("계좌 번호: " + otherAccount.identifier()));

    otherTransferPaenl.add(new JLabel("보낼 계좌 번호"));
    JTextField otherAccountInputField = new JTextField(10);
    otherTransferPaenl.add(otherAccountInputField);

    otherTransferPaenl.add(new JLabel("보낼 금액"));
    JTextField otherAmountInputField = new JTextField(10);
    otherTransferPaenl.add(otherAmountInputField);

    JButton button = new JButton("송금");
    button.addActionListener(event -> {
      String identifier = otherAccountInputField.getText();
      int sendAmount = Integer.parseInt(otherAmountInputField.getText());
      otherAccount.transfer(myAccount, otherAccount, identifier, sendAmount);
    });
    otherTransferPaenl.add(button);
  }
}
