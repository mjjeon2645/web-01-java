import javax.swing.*;
import java.awt.*;

public class TransactionsPanel extends JPanel {
  public TransactionsPanel(Account account) {

    this.setLayout(new GridLayout(0, 2));

    JLabel titleLabel = new JLabel("거래 내역");
    this.add(titleLabel);

    JLabel nullLabel = new JLabel("    ");
    this.add(nullLabel);

    for (String transaction : account.transactionsOfMine()) {
      JLabel identifierOfOthersLabel = new JLabel("계좌 번호: " + account.identifierOfOthers());
      this.add(identifierOfOthersLabel);

      JLabel transactionLabel = new JLabel(transaction);
      this.add(transactionLabel);
    }
  }
}
