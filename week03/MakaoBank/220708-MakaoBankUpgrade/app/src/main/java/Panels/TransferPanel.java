package Panels;

import models.*;
import services.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class TransferPanel extends JPanel {
  private Account myAccount;
  private Account yourAccount;
  private TransferService transferservice;

  public TransferPanel(Account myAccount, Account yourAccount) {
    this.myAccount = myAccount;
    this.yourAccount = yourAccount;

    this.setLayout(new GridLayout(2, 1));
    this.setBorder(new MatteBorder(2,2,2,2,Color.BLACK));

    manageMyAccountTransferPanel();

    manageYourAccountTransferPanel();

  }

  private void manageMyAccountTransferPanel() {
    JPanel panel = new JPanel();
    this.add(panel);
    panel.setLayout(new GridLayout(4,2));
    panel.setBorder(new MatteBorder(1,1,1,1,Color.BLACK));

    JLabel titleLabel = new JLabel("냬 계좌에서 송금하기");
    panel.add(titleLabel);
    JLabel blankLabel1 = new JLabel("");
    panel.add(blankLabel1);

    JLabel receiverAccountNumberLabel = new JLabel("계좌 번호:");
    panel.add(receiverAccountNumberLabel);
    JTextField receiverAccountNumberTextField = new JTextField(5);
    panel.add(receiverAccountNumberTextField);

    JLabel transferAmountLabel = new JLabel("금액: ");
    panel.add(transferAmountLabel);
    JTextField transferAmountTextField = new JTextField(5);
    panel.add(transferAmountTextField);

    JLabel blankLabel2 = new JLabel("");
    panel.add(blankLabel2);
    JButton button = new JButton(" 송금 ");
    panel.add(button);
    button.addActionListener(event -> {
      String inputAccountNumber = receiverAccountNumberTextField.getText();
      int transferAmount = Integer.parseInt(transferAmountTextField.getText());

      transferservice = new TransferService();
      transferservice.transfer(myAccount,yourAccount,transferAmount,inputAccountNumber);
    });
  }

  private void manageYourAccountTransferPanel() {
    JPanel panel = new JPanel();
    this.add(panel);
    panel.setLayout(new GridLayout(4,2));
    panel.setBorder(new MatteBorder(1,1,1,1,Color.BLACK));

    JLabel titleLabel = new JLabel("상대 계좌에서 입금하기");
    panel.add(titleLabel);
    JLabel blankLabel1 = new JLabel("");
    panel.add(blankLabel1);

    JLabel receiverAccountNumberLabel = new JLabel("계좌 번호:");
    panel.add(receiverAccountNumberLabel);
    JTextField receiverAccountNumberTextField = new JTextField(5);
    panel.add(receiverAccountNumberTextField);

    JLabel transferAmountLabel = new JLabel("금액: ");
    panel.add(transferAmountLabel);
    JTextField transferAmountTextField = new JTextField(5);
    panel.add(transferAmountTextField);

    JLabel blankLabel2 = new JLabel("");
    panel.add(blankLabel2);
    JButton button = new JButton(" 입금 ");
    panel.add(button);
  }
}