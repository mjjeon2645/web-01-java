import javax.swing.*;
import java.awt.*;

public class AmountPanel extends JPanel {
  private final Account account;

  public AmountPanel(Account account) {
    this.account = account;

    this.setLayout(new GridLayout(2, 1));
    
    this.add(new JLabel(accountIdentifier()));
    this.add(new JLabel(amount()));
  }

  private String accountIdentifier() {
    return "계좌번호: " + account.getIdentifier();
  }

  private String amount() {
    return "잔액: " + account.getAmount() + "원";
  }
}
