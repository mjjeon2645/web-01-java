import javax.swing.*;
import java.awt.*;

public class TransactionsPanel extends JPanel {
  private final Account account;

  public TransactionsPanel(Account account) {
    this.account = account;

    this.setLayout(new GridLayout(account.transactions().size() + 1, 1));

    initTitleLabel();
    initTransactionLabels();
  }

  public void initTransactionLabels() {
    for (String transaction : account.transactions()) {
      this.add(new JLabel(transaction));
    }
  }

  public void initTitleLabel() {
    this.add(new JLabel("거래 내역"));
  }
}
