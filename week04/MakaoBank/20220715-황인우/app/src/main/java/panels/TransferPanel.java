package panels;

import models.Account;

import javax.swing.*;
import java.awt.*;

public class TransferPanel extends JPanel {
  private final Account myAccount;
  private final Account otherAccount;

  private JTextField otherIdentifierInputTextField;
  private JTextField amountForOtherAccountInputTextField;

  private JTextField myIdentifierInputTextField;
  private JTextField amountForMyAccountInputTextField;

  public TransferPanel(Account myAccount, Account otherAccount) {
    this.myAccount = myAccount;
    this.otherAccount = otherAccount;

    this.setLayout(new GridLayout(0, 1));

    createTransferToOtherAccountPanel();
    createTransferToMyAccountPanel();
  }

  public void createTransferToOtherAccountPanel() {
    JPanel transferToOtherAccountPanel = new JPanel();

    transferToOtherAccountPanel.setLayout(new GridLayout(0, 1));

    //내 계좌번호
    transferToOtherAccountPanel.add(
        new JLabel("계좌 번호: " + myAccount.identifier())
    );

    //보낼 계좌번호
    JPanel otherIdentifierInputPanel = new JPanel();
    otherIdentifierInputPanel.add(new JLabel("보낼 계좌 번호: "));

    otherIdentifierInputTextField = new JTextField(12);
    otherIdentifierInputPanel.add(otherIdentifierInputTextField);

    transferToOtherAccountPanel.add(otherIdentifierInputPanel);

    //이체할 금액
    JPanel amountForOtherAccountInputPanel = new JPanel();
    amountForOtherAccountInputPanel.add(new JLabel("이체할 금액: "));

    amountForOtherAccountInputTextField = new JTextField(12);
    amountForOtherAccountInputPanel.add(amountForOtherAccountInputTextField);

    transferToOtherAccountPanel.add(amountForOtherAccountInputPanel);

    //상대에게 송금
    transferToOtherAccountPanel.add(createTransferToOtherAccountButton());

    this.add(transferToOtherAccountPanel);
  }

  public JButton createTransferToOtherAccountButton() {
    JButton button = new JButton("송금");
    button.addActionListener(event -> {
      String otherIdentifier = otherIdentifierInputTextField.getText();

      if (otherIdentifier.equals(otherAccount.identifier())) {
        long transferAmount
            = Long.parseLong(amountForOtherAccountInputTextField.getText());

        myAccount.transfer(otherAccount, transferAmount);
      }
    });

    return button;
  }

  public void createTransferToMyAccountPanel() {
    JPanel transferToMyAccountPanel = new JPanel();

    transferToMyAccountPanel.setLayout(new GridLayout(0, 1));

    //상대 계좌번호
    transferToMyAccountPanel.add(
        new JLabel("계좌 번호: " + otherAccount.identifier())
    );

    //보낼 계좌번호
    JPanel myIdentifierInputPanel = new JPanel();
    myIdentifierInputPanel.add(new JLabel("보낼 계좌 번호: "));

    myIdentifierInputTextField = new JTextField(12);
    myIdentifierInputPanel.add(myIdentifierInputTextField);

    transferToMyAccountPanel.add(myIdentifierInputPanel);

    //이체할 금액
    JPanel amountForMyAccountInputPanel = new JPanel();
    amountForMyAccountInputPanel.add(new JLabel("이체할 금액: "));

    amountForMyAccountInputTextField = new JTextField(12);
    amountForMyAccountInputPanel.add(amountForMyAccountInputTextField);

    transferToMyAccountPanel.add(amountForMyAccountInputPanel);

    //내게 송금
    transferToMyAccountPanel.add(createTransferToMyAccountButton());

    this.add(transferToMyAccountPanel);
  }

  public JButton createTransferToMyAccountButton() {
    JButton button = new JButton("송금");
    button.addActionListener(event -> {
      String myIdentifier = myIdentifierInputTextField.getText();

      if (myIdentifier.equals(myAccount.identifier())) {
        long transferAmount
            = Long.parseLong(amountForMyAccountInputTextField.getText());

        otherAccount.transfer(myAccount, transferAmount);
      }
    });

    return button;
  }
}
