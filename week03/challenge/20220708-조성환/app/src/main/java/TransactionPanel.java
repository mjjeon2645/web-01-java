//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.GridLayout;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TransactionPanel extends JPanel {
  TransactionPanel(Account account) {
    this.setLayout(new GridLayout(account.transactionSize() + 1, 1));
    JLabel label = new JLabel("거래 내역");
    this.add(label);

    for(String transaction : account.transactions()){
    JLabel transactionLabel = new JLabel(transaction);
    this.add(transactionLabel);
  }

}
}