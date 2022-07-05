import javax.swing.*;
import java.awt.*;

public class AmountPanel extends JPanel {
  private final Account account;

  public AmountPanel(Account account) {
    this.account = account;

    this.setLayout(new GridLayout(2, 1));

    initIdentifierLabel();
    initAmountLabel();
  }

  public void initIdentifierLabel() {
    this.add(new JLabel("계좌번호: " + account.identifier()));
  }

  public void initAmountLabel() {
    this.add(new JLabel("잔액: " + account.amount() + "원"));
  }
}
