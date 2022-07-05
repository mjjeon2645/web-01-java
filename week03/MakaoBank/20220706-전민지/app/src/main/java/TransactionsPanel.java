import javax.swing.*;
import java.awt.*;

public class TransactionsPanel extends JPanel {
  TransactionsPanel(Account account) {

    setLayout(new GridLayout(account.transactionsSize() + 1, 1));

    JLabel titleLabel = new JLabel("거래 내역");
    this.add(titleLabel);

    for (String transaction : account.transactions()) {
      JLabel label = new JLabel(transaction);
      this.add(label);
    }
  }
}
