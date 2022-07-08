import javax.swing.*;
import java.awt.*;

public class TransactionsPanel extends JPanel {
  TransactionsPanel(Account account) {
    this.setLayout(new GridLayout(1 + account.transactionSize(), 1));

    JLabel label = new JLabel("거래내역");
    this.add(label);

    for(String transaction : account.transactions()){
      JLabel transactionLabel = new JLabel(transaction);
      this.add(transactionLabel);
    }
  }
}
