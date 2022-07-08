import javax.swing.*;
import java.awt.*;

public class TransactionPanel extends JPanel {
  TransactionPanel(Account account) {
    this.setLayout(new GridLayout(2 + account.transactionSize(), 1));

    JLabel label = new JLabel("거래 내역");
    this.add(label);

    for (String myTransaction : account.myTransactions()) {
      JLabel transactionLabel = new JLabel(myTransaction);
      this.add(transactionLabel);
    }

    for (String counterpartTransaction : account.counterpartTransactions()) {
      JLabel counterpartTransactionLabel = new JLabel(counterpartTransaction);
      this.add(counterpartTransactionLabel);
    }
  }
}
