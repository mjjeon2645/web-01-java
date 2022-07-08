import javax.swing.*;
import java.awt.*;

public class TransactionsPanel extends JPanel {
  public TransactionsPanel(
      AccountRepository accountRepository,
      String myAccountIdentifier, String otherAccountIdentifier) {
    this.setLayout(new GridLayout(0, 1));

    this.add(new JLabel("거래 내역"));

    JPanel myTransactionsPanel = new JPanel();
    myTransactionsPanel.setLayout(new GridLayout(0, 1));
    for (String transaction :
        accountRepository.transactions(myAccountIdentifier)) {
      myTransactionsPanel.add(new JLabel(transaction));
    }

    this.add(myTransactionsPanel);

    JPanel otherTransactionsPanel = new JPanel();
    otherTransactionsPanel.setLayout(new GridLayout(0, 1));
    for (String transaction :
        accountRepository.transactions(otherAccountIdentifier)) {
      otherTransactionsPanel.add(new JLabel(transaction));
    }

    this.add(otherTransactionsPanel);
  }
}
