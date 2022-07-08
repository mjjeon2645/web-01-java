import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TransactionsPanel extends JPanel {
  private Account account;

  public TransactionsPanel(Account account) {
    this.account = account;

    this.setLayout(new GridLayout(2, 1));

    initMyTransactions();

    initTheOtherTransactions();
  }

  public void initMyTransactions() {
    JPanel myTransactionsPanel = new JPanel();
    myTransactionsPanel.setBorder(new LineBorder(Color.BLACK, 3));
    myTransactionsPanel.setLayout(new GridLayout(0, 1, 10, 10));
    this.add(myTransactionsPanel);

    JLabel titleLabel1 = new JLabel("내 계좌 거래 내역");
    myTransactionsPanel.add(titleLabel1);

    for (String myTransaction : account.myTransactions()) {
      JLabel identifierLabel1 = new JLabel("계좌 번호: " + account.theOtherIdentifier()
          + "     " + myTransaction);
      myTransactionsPanel.add(identifierLabel1);
    }
  }

  public void initTheOtherTransactions() {
    JPanel theOtherTransactionsPanel = new JPanel();
    theOtherTransactionsPanel.setBorder(new LineBorder(Color.BLACK, 3));
    theOtherTransactionsPanel.setLayout(new GridLayout(0, 1, 10, 10));
    this.add(theOtherTransactionsPanel);

    JLabel titleLabel2 = new JLabel("상대 계좌 거래 내역");
    theOtherTransactionsPanel.add(titleLabel2);

    for (String theOtherTransaction : account.theOtherTransactions()) {
      JLabel identifierLabel2 = new JLabel("계좌 번호: " + account.theOtherIdentifier()
          + "     " + theOtherTransaction);
      theOtherTransactionsPanel.add(identifierLabel2);
    }
  }
}
