import javax.swing.*;
import java.awt.*;

public class AmountPanel extends JPanel {
  AmountPanel(Account account) {
    this.setLayout(new GridLayout(2, 1));

    this.add(new JLabel("계좌번호 " + account.identifier()));
    this.add(new JLabel("잔액 " + account.amount() + "원"));
  }
}
