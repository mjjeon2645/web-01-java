import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TransactionPanel extends JPanel {
  TransactionPanel(Account account) {
    this.setLayout(new GridLayout(account.transactionSize() + 1, 1));
    JLabel label = new JLabel("거래 내역");
    this.add(label);

    for (String transaction : account.transactions()) {
      JLabel transactionLabel = new JLabel(transaction);
      this.add(transactionLabel);
    }
  }
}
