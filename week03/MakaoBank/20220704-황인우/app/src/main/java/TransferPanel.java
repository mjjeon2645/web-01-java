import javax.swing.*;
import java.awt.*;

public class TransferPanel extends JPanel {
  private final Account account;

  private JTextField textField;

  public TransferPanel(Account account) {
    this.account = account;
    
    this.setLayout(new GridLayout(3, 1));

    initTitleLabel();
    initTextField();
    initTransferButton();
  }

  public void initTitleLabel() {
    this.add(new JLabel("송금하기"));
  }

  public void initTextField() {
    textField = new JTextField(15);
    this.add(textField);
  }

  public void initTransferButton() {
    JButton button = new JButton("송금");
    button.addActionListener(event -> {
      transfer();
    });
    this.add(button);
  }

  public void transfer() {
    long amount = Long.parseLong(textField.getText());

    account.transfer(amount);
  }
}
