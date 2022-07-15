package panels;

import models.Account;

import javax.swing.*;
import java.awt.*;

public class TransferPanel extends JPanel {
  private Account account;

  private JPanel myTransferPanel;
  private JPanel otherTransferPanel;

  private JTextField sendingAccountNumberTextField;
  private JTextField sendingAmountTextField;
  private JTextField otherSendingAccountNumberTextField;
  private JTextField otherSendingAmountTextField;

  public TransferPanel(Account account) {
    this.account = account;

    this.setLayout(new GridLayout(2, 1));

    createMyTransferPanel();
    createMyAccountNumber();
    createSendingOtherAcoountNumber();
    createOtherSendingAmount();
    createTransferButton(account);

    createOtherTransferPanel();
    createOtherAccountNumber();
    createSendingMyAcoountNumber();
    createMySendingAmount();
    createOtherTransferButton(account);
  }

  public void createMyTransferPanel() {
    myTransferPanel = new JPanel();
    myTransferPanel.setLayout(new GridLayout(4, 0));
    this.add(myTransferPanel);
  }

  public void createMyAccountNumber() {
    myTransferPanel.add(new JLabel("계좌번호: " + account.myAccountNumber()));
  }

  public void createSendingOtherAcoountNumber() {
    JLabel sendingAccountNumberLabel = new JLabel("보낼 계좌 번호: ");
    myTransferPanel.add(sendingAccountNumberLabel);

    sendingAccountNumberTextField = new JTextField(10);
    myTransferPanel.add(sendingAccountNumberTextField);
  }

  public void createOtherSendingAmount() {
    JLabel sendingAmountLabel = new JLabel("이체할 금액");
    myTransferPanel.add(sendingAmountLabel);

    sendingAmountTextField = new JTextField(10);
    myTransferPanel.add(sendingAmountTextField);
  }

  public void createTransferButton(Account account) {
    JButton transferButton = new JButton("송금");
    transferButton.addActionListener(event -> {
      String accountNumber = sendingAccountNumberTextField.getText();
      int amount = Integer.parseInt(sendingAmountTextField.getText());

      if (accountNumber.equals(account.otherAccountNumber())) {
        account.myTransfer(amount);
      }
    });

    myTransferPanel.add(transferButton);
  }

  public void createOtherTransferPanel() {
    otherTransferPanel = new JPanel();
    otherTransferPanel.setLayout(new GridLayout(4, 1));
    this.add(otherTransferPanel);
  }

  public void createOtherAccountNumber() {
    otherTransferPanel.add(new JLabel("계좌번호: " +
        account.otherAccountNumber()));
  }

  public void createSendingMyAcoountNumber() {
    JLabel sendingAccountNumberLabel = new JLabel("보낼 계좌 번호: ");
    otherTransferPanel.add(sendingAccountNumberLabel);

    otherSendingAccountNumberTextField = new JTextField(10);
    otherTransferPanel.add(otherSendingAccountNumberTextField);
  }

  public void createMySendingAmount() {
    JLabel sendingAmountLabel = new JLabel("이체할 금액");
    otherTransferPanel.add(sendingAmountLabel);

    otherSendingAmountTextField = new JTextField(10);
    otherTransferPanel.add(otherSendingAmountTextField);
  }

  public void createOtherTransferButton(Account account) {
    JButton transferButton = new JButton("송금");
    transferButton.addActionListener(event -> {
      String accountNumber = otherSendingAccountNumberTextField.getText();
      int amount = Integer.parseInt(otherSendingAmountTextField.getText());

      if (accountNumber.equals(account.myAccountNumber())) {
        account.otherTransfer(amount);
      }
    });

    otherTransferPanel.add(transferButton);
  }
}
