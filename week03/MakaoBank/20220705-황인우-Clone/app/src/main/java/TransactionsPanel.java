import javax.swing.*;
import java.awt.*;

public class TransactionsPanel extends JPanel {
  private final Account account;

  public TransactionsPanel(Account account) {
    this.account = account;

    this.setLayout(new GridLayout(account.transactionsSize() + 1, 1));

    JLabel label = new JLabel("거래 내역");
    this.add(label);

    for (String transaction : account.getTransactions()) {
      this.add(new JLabel(transaction));
    }
  }
}
