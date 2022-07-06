import javax.swing.*;
import java.awt.*;

public class TransferPanel extends JPanel {
  TransferPanel(Account account) {

    this.setLayout(new GridLayout(3,1));

    JLabel label = new JLabel("송금하기");
    label.setHorizontalAlignment(JLabel.CENTER);
    this.add(label);

    JTextField textField = new JTextField(10);
    this.add(textField);

    JButton button = new JButton("확인");
    button.addActionListener(event -> {
      long amount = Long.parseLong(textField.getText());
      account.transfer(amount);
    });
    this.add(button);
  }
}
