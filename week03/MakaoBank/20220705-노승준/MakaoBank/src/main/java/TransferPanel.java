import javax.swing.*;
import java.awt.*;

public class TransferPanel extends JPanel {
  private Account account;

  TransferPanel(Account account) {
    this.account = account;

    this.setLayout(new GridLayout(3,1));

    this.add(new JLabel("송금 하기"));

    JTextField textField = new JTextField(10);
    this.add(textField);

    JButton button = new JButton("송금");
    button.addActionListener(event -> {
      long amount = Long.parseLong(textField.getText());
      account.transfer(amount);
    });
    this.add(button);
  }
}
