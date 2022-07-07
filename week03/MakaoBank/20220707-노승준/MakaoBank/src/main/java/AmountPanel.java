import javax.swing.*;
import java.awt.*;

public class AmountPanel extends JPanel {
  private Account account;

  AmountPanel(Account account) {
    this.account = account;
    this.setLayout(new GridLayout(2, 1));

    this.add(new JLabel("계좌번호: " + account.getAccountNumber()));

    this.add(new JLabel("잔액: " + account.getAmount() + "원"));
  }
}
