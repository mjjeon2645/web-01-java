import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionsPanel extends JPanel {
  TransactionsPanel(Account account) {

    this.setLayout(new GridLayout(account.transactionsSize() + 1, 1));

    JLabel label = new JLabel("거래내역");
    this.add(label);

    for(String transaction : account.transactions()){
      JLabel transactionLabel = new JLabel(transaction);
      this.add(transactionLabel);
    }
  }
}
