import javax.swing.*;
import java.awt.*;

public class TransactionPanel extends JPanel {
  TransactionPanel(Account account) {
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(account.getTransactions().size() + 1, 1));
    this.add(panel);

    JLabel label = new JLabel("거래내역");
    label.setHorizontalAlignment(JLabel.CENTER);
    panel.add(label);

    for (String transaction : account.getTransactions()) {
      JLabel transactionLabel = new JLabel(transaction);
      transactionLabel.setHorizontalAlignment(JLabel.CENTER);
      panel.add(transactionLabel);
    }
  }
}
