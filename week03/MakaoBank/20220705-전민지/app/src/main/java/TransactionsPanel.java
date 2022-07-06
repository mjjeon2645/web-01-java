import javax.swing.*;
import java.awt.*;

public class TransactionsPanel extends JPanel {
  TransactionsPanel(Account account) {

    setLayout(new GridLayout(account.transactionsSize() + 1, 1));

    JLabel label = new JLabel("거래 내역");
    this.add(label);

    for (String transaction : account.transactions()) {
      JLabel transactionsLabel = new JLabel(transaction);
      this.add(transactionsLabel);
    }
  }
}
