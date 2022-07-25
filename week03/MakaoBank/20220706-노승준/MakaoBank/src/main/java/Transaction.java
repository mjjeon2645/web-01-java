import javax.swing.*;
import java.awt.*;

public class Transaction extends JPanel {
  Transaction(Account account) {
    this.setLayout(new GridLayout(1 + account.transactionSize(), 1));
    this.add(new JLabel("거래내역"));

    for(String transaction : account.getTransactions()) {
      this.add(new JLabel("송금: " + transaction + "원"));
    }
  }
}
