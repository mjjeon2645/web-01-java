import javax.swing.*;
import java.awt.*;

public class TransactionPanel extends JPanel {
  private Account account;
  TransactionPanel(Account account) {
    this.account = account;

    this.setLayout(new GridLayout(1 + account.transactionSize(), 1));

    this.add(new JLabel("거래 내역"));

    for(String transaction : account.transactions()) {
      this.add(new JLabel("송금: " + transaction + "원"));
    }
  }
}
