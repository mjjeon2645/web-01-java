import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class AmountPanel extends JPanel {
  private Account account;
  private JPanel myAmountPanel;
  private JPanel theOtherAmountPanel;

  AmountPanel(Account account) {
    this.account = account;

    this.setLayout(new GridLayout(2, 1));

    initMyAmount();

    initTheOtherAmount();
  }

  public void initMyAmount() {
    myAmountPanel = new JPanel();
    myAmountPanel.setLayout(new GridLayout(3, 1, 30, 30));
    myAmountPanel.setBorder(new LineBorder(Color.BLACK, 3));

    JLabel titleLabel1 = new JLabel("내 계좌");
    myAmountPanel.add(titleLabel1);

    JLabel myIdentifierLabel = new JLabel("계좌 번호: " + account.myIdentifier());
    myAmountPanel.add(myIdentifierLabel);

    JLabel myAmountLabel = new JLabel("잔액: " + account.myAmount() + "원");
    myAmountPanel.add(myAmountLabel);

    this.add(myAmountPanel);
  }

  public void initTheOtherAmount() {
    theOtherAmountPanel = new JPanel();
    theOtherAmountPanel.setLayout(new GridLayout(3, 1, 30, 30));
    theOtherAmountPanel.setBorder(new LineBorder(Color.BLACK, 3));

    JLabel titleLabel2 = new JLabel("상대 계좌");
    theOtherAmountPanel.add(titleLabel2);

    JLabel theOtherIdentifierLabel = new JLabel("계좌 번호: " + account.theOtherIdentifier());
    theOtherAmountPanel.add(theOtherIdentifierLabel);

    JLabel theOtherAmountLabel = new JLabel("잔액: " + account.theOtherAmount() + "원");
    theOtherAmountPanel.add(theOtherAmountLabel);

    this.add(theOtherAmountPanel);
  }
}
