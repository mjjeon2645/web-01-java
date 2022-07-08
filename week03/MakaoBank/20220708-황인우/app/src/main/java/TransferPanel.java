import javax.swing.*;
import java.awt.*;

public class TransferPanel extends JPanel {
  public TransferPanel(
      TransferService transferService, String myIdentifier) {
    this.setLayout(new GridLayout(0, 1));

    this.add(new JLabel("내 계좌에서 송금하기"));

    JPanel transferInputPanel = new JPanel();

    transferInputPanel.add(new JLabel("계좌 번호: "));

    JTextField otherIdentifierInputTextField = new JTextField(12);
    transferInputPanel.add(otherIdentifierInputTextField);

    transferInputPanel.add(new JLabel("금액: "));

    JTextField transferAmountTextField = new JTextField(12);
    transferInputPanel.add(transferAmountTextField);

    JButton transferToOtherAccountButton = new JButton("송금");
    transferToOtherAccountButton.addActionListener(event -> {
      String enteredOtherIdentifier = otherIdentifierInputTextField.getText();
      long transferAmount = Long.parseLong(transferAmountTextField.getText());
      transferService.transfer(
          myIdentifier, enteredOtherIdentifier, transferAmount
      );
    });
    transferInputPanel.add(transferToOtherAccountButton);

    this.add(transferInputPanel);

    this.add(new JLabel("상대 계좌에서 입금하기"));

    JPanel depositInputPanel = new JPanel();

    depositInputPanel.add(new JLabel("계좌 번호: "));

    JTextField otherIdentifierInputTextField2 = new JTextField(12);
    depositInputPanel.add(otherIdentifierInputTextField2);

    depositInputPanel.add(new JLabel("금액: "));

    JTextField depositAmountTextField = new JTextField(12);
    depositInputPanel.add(depositAmountTextField);

    JButton depositToMyAccountButton = new JButton("입금");
    depositToMyAccountButton.addActionListener(event -> {
      String enteredOtherIdentifier = otherIdentifierInputTextField2.getText();
      long depositAmount = Long.parseLong(depositAmountTextField.getText());
      transferService.transfer(
          enteredOtherIdentifier, myIdentifier, depositAmount
      );
    });
    depositInputPanel.add(depositToMyAccountButton);

    this.add(depositInputPanel);
  }
}
