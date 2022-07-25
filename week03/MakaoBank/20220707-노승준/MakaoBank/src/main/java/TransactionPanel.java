import javax.swing.*;
import java.awt.*;

public class TransactionPanel extends JPanel {
  TransactionPanel(Account account) {
    this.setLayout(new GridLayout(1 + account.transactionSize(), 1));

    JLabel label = new JLabel("거래 내역");
    this.add(label);

    for (String transaction : account.transactions()) {
      JLabel transactionLabel = new JLabel(transaction);
      this.add(transactionLabel);
    }
  }
}
