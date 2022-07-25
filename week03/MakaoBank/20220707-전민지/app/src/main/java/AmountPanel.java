import javax.swing.*;
import java.awt.*;

public class AmountPanel extends JPanel {

  AmountPanel(Account account) {
    this.setLayout(new GridLayout(0, 1));

    String accountNumber = account.getAccountNumber();
    JLabel accountNumberLabel = new JLabel(accountNumber);
    this.add(accountNumberLabel);

    long amount = account.getAmount();
    JLabel amountLabel = new JLabel("잔액: " + amount + "원");
    this.add(amountLabel);
  }
}
