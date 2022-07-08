import javax.swing.*;
import java.awt.*;

public class TransactionsPanel extends JPanel {
  public TransactionsPanel(Account account) {

    this.setLayout(new GridLayout(account.transactionsOfMine().size() + 1, 2));

    // TODO. 거래내역이 보여야 함(내 계좌에 한한 내용만 보여도 됨 우선은)

    JLabel titleLabel = new JLabel("거래 내역");
    this.add(titleLabel);

    JLabel nullLabel = new JLabel("    ");
    this.add(nullLabel);

    for (String transaction : account.transactionsOfMine()) {
      JLabel identifierOfOthersLabel = new JLabel("계좌번호: " + account.identifierOfOthers());
      this.add(identifierOfOthersLabel);

      JLabel transactionLabel = new JLabel(transaction);
      this.add(transactionLabel);
    }
  }
}
