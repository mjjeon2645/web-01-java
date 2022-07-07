import javax.swing.*;

public class AmountPanel extends JPanel {
  public AmountPanel(Account account) {
    String identifier = account.identifier();

    this.add(new JLabel("계좌번호: " + identifier));

    long amount = account.amount();

    this.add(new JLabel("잔액: " + amount + "원"));
  }
}
