import javax.swing.*;
import java.awt.*;

public class TransactionsPanel extends JPanel {
  public TransactionsPanel(Account account) {
    this.setLayout(new GridLayout(account.transactions().size() + 1, 1));

    this.add(new JLabel("거래 내역"));

    for (String transaction : account.transactions()) {
      this.add(new JLabel(transaction));
    }
  }
}
