import javax.swing.*;
import java.awt.*;

public class TransactionsPanel extends JPanel {
  TransactionsPanel(Account account) {

    this.setLayout(new GridLayout(account.transactionsSize() + 1, 1));

    JLabel titleLabel = new JLabel("거래 내역");
    add(titleLabel);

    for (String transaction : account.transactions()) {
      this.add(new JLabel(transaction));
    }
  }
}
