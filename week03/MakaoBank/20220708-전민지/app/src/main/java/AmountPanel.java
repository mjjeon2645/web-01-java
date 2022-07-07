import javax.swing.*;
import java.awt.*;

public class AmountPanel extends JPanel {

  AmountPanel(Account account) {

    this.setLayout(new GridLayout(0, 1));

    long amount = account.getAmount();

    JLabel titleLabel = new JLabel(account.getAccountNumber());
    this.add(titleLabel);

    JLabel amountLabel = new JLabel("잔액: " + amount + "원");
    this.add(amountLabel);
  }
}
