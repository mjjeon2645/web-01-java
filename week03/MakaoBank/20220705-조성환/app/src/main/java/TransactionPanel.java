import javax.swing.*;
import java.awt.*;
import java.util.jar.JarEntry;

public class TransactionPanel extends JPanel {
  TransactionPanel(Account account) {

    this.setLayout(new GridLayout(account.TransactionsSize() + 1, 1));

    this.add(new JLabel("거래내역"));

    for(String transaction : account.transactions()){
      JLabel label = new JLabel(transaction);
      this.add(label);
    }
  }
}