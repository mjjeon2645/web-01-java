package panels;

import models.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class TransferPanel extends JPanel {
  private Account account1;
  private Account account2;

  public TransferPanel(Account account1, Account account2) {
    this.account1 = account1;
    this.account2 = account2;

    this.setLayout(new GridLayout(2, 1));
    this.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));

    manageAccount1TransferPanel(account1, account2);
    manageAccount2TransferPanel();
  }

  private void manageAccount1TransferPanel(Account account1, Account account2) {
    JPanel panel = new JPanel();
    this.add(panel);
    panel.setLayout(new GridLayout(4, 2));
    panel.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
    JLabel titleLabel = new JLabel("냬 계좌에서 송금하기");
    panel.add(titleLabel);
    JLabel blankLabel1 = new JLabel("");
    panel.add(blankLabel1);
    JLabel receiverAccountNumberLabel = new JLabel("보낼 계좌 번호:");
    panel.add(receiverAccountNumberLabel);
    JTextField receiverAccountNumberTextField = new JTextField(5);
    panel.add(receiverAccountNumberTextField);
    JLabel transferAmountLabel = new JLabel("이체할 금액: ");
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

      account1.transfer(account2, transferAmount, inputAccountNumber);

      account2.deposit(account2, transferAmount, inputAccountNumber);
      if (account2.getAccountNumber().equals(inputAccountNumber)) {

        receiverAccountNumberTextField.setText("");
        transferAmountTextField.setText("");

      }
    });
  }

  private void manageAccount2TransferPanel() {
    JPanel panel = new JPanel();
    this.add(panel);
    panel.setLayout(new GridLayout(4, 2));
    panel.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
    JLabel titleLabel = new JLabel("상대 계좌에서 입금하기");
    panel.add(titleLabel);
    JLabel blankLabel1 = new JLabel("");
    panel.add(blankLabel1);
    JLabel receiverAccountNumberLabel = new JLabel("보낼 계좌 번호:");
    panel.add(receiverAccountNumberLabel);
    JTextField receiverAccountNumberTextField = new JTextField(5);
    panel.add(receiverAccountNumberTextField);
    JLabel transferAmountLabel = new JLabel("이체할 금액: ");
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

      account2.transfer(account1, transferAmount, inputAccountNumber);
      account1.deposit(account1, transferAmount, inputAccountNumber);
      if (account1.getAccountNumber().equals(inputAccountNumber)) {
        receiverAccountNumberTextField.setText("");
        transferAmountTextField.setText("");

      }
    });
  }
}