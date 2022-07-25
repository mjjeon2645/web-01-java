import javax.swing.*;
import java.awt.*;

public class AmountPanel extends JPanel {
  AmountPanel(Account account) {
    this.setLayout(new GridLayout(2, 1));

    JLabel label = new JLabel("계좌번호 : " + account.getAccountNumber());
    this.add(label);

    JLabel amountLabel = new JLabel("잔액: " + account.getAmount() + "원");
    this.add(amountLabel);
  }
}
