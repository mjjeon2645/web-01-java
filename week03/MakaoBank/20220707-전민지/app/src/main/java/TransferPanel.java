import javax.swing.*;
import java.awt.*;

public class TransferPanel extends JPanel {
  TransferPanel(Account account) {

    this.setLayout(new GridLayout(0, 1));

    JLabel label = new JLabel("송금");
    this.add(label);

    JTextField textField = new JTextField(10);
    this.add(textField);

    JButton button = new JButton("확인");
    button.addActionListener(event -> {
      long transferAmount = Long.valueOf(textField.getText());
      account.transfer(transferAmount);
    });
    this.add(button);
  }
}
