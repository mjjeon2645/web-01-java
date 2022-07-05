import javax.swing.*;
import java.awt.*;

public class Amountpanel extends JPanel {
  private final Account account;

  Amountpanel(Account account) {
    this.account = account;

    this.setLayout(new GridLayout(2, 1));

    this.add(new JLabel(accountNumber()));
    this.add(new JLabel(amount()));
  }

  public String amount() {
    return "잔액: " + account.getAmount() + "원";
  }

  public String accountNumber() {
    return "계좌번호: " + account.getNumber();
  }
}
