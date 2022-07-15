package panels;

import models.Account;

import javax.swing.*;
import java.awt.*;

public class TransferPanel extends JPanel {
  public TransferPanel(Account myAccount, Account otherAccount) {
    this.setLayout(new GridLayout(0, 1));

    //내 계좌번호
    JLabel myIdentifierLabel = new JLabel("계좌 번호: " + myAccount.identifier());
    this.add(myIdentifierLabel);

    //보낼 계좌번호
    JPanel otherIdentifierInputPanel = new JPanel();
    JLabel otherIdentifierInputLabel = new JLabel("보낼 계좌 번호: ");
    otherIdentifierInputPanel.add(otherIdentifierInputLabel);
    JTextField otherIdentifierInputTextField = new JTextField(12);
    otherIdentifierInputPanel.add(otherIdentifierInputTextField);
    this.add(otherIdentifierInputPanel);

    //이체할 금액
    JPanel amountForOtherAccountInputPanel = new JPanel();
    JLabel amountForOtherAccountInputLabel = new JLabel("이체할 금액: ");
    amountForOtherAccountInputPanel.add(amountForOtherAccountInputLabel);
    JTextField amountForOtherAccountInputTextField = new JTextField(12);
    amountForOtherAccountInputPanel.add(amountForOtherAccountInputTextField);
    this.add(amountForOtherAccountInputPanel);

    //상대에게 송금
    JButton transferToOtherAccountButton = new JButton("송금");
    transferToOtherAccountButton.addActionListener(event -> {
      String otherIdentifier = otherIdentifierInputTextField.getText();

      if (otherIdentifier.equals(otherAccount.identifier())) {
        long transferAmount
            = Long.parseLong(amountForOtherAccountInputTextField.getText());

        myAccount.transfer(otherAccount, transferAmount);
      }
    });
    this.add(transferToOtherAccountButton);

    //상대 계좌번호
    JLabel otherIdentifierLabel = new JLabel("계좌 번호: " + otherAccount.identifier());
    this.add(otherIdentifierLabel);

    //보낼 계좌번호
    JPanel myIdentifierInputPanel = new JPanel();
    JLabel myIdentifierInputLabel = new JLabel("보낼 계좌 번호: ");
    myIdentifierInputPanel.add(myIdentifierInputLabel);
    JTextField myIdentifierInputTextField = new JTextField(12);
    myIdentifierInputPanel.add(myIdentifierInputTextField);
    this.add(myIdentifierInputPanel);

    //이체할 금액
    JPanel amountForMyAccountInputPanel = new JPanel();
    JLabel amountForMyAccountInputLabel = new JLabel("이체할 금액: ");
    amountForMyAccountInputPanel.add(amountForMyAccountInputLabel);
    JTextField amountForMyAccountInputTextField = new JTextField(12);
    amountForMyAccountInputPanel.add(amountForMyAccountInputTextField);
    this.add(amountForMyAccountInputPanel);

    //내게 송금
    JButton transferToMyAccountButton = new JButton("송금");
    transferToMyAccountButton.addActionListener(event -> {
      String myIdentifier = myIdentifierInputTextField.getText();

      if (myIdentifier.equals(myAccount.identifier())) {
        long transferAmount
            = Long.parseLong(amountForMyAccountInputTextField.getText());

        otherAccount.transfer(myAccount, transferAmount);
      }
    });
    this.add(transferToMyAccountButton);
  }
}
