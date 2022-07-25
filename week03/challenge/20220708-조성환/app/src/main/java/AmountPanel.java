import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AmountPanel extends JPanel {
  private Account account;

  AmountPanel(Account account) {
    this.account = account;
    this.setLayout(new GridLayout(2, 1));

    this.myAccount();
    this.otherAccount();
  }

  private void myAccount() {
    JPanel myAccountPanel = new JPanel();
    this.add(myAccountPanel);
    myAccountPanel.setLayout(new GridLayout(3, 1));
    myAccountPanel.add(new JLabel("내 계좌"));
    myAccountPanel.add(new JLabel("계좌 번호 : " + account.myAccountIdentifier()));
    myAccountPanel.add(new JLabel("잔액 : " + account.myAccountAmount()));
  }

  private void otherAccount() {
    JPanel otherAccountPanel = new JPanel();
    this.add(otherAccountPanel);
    otherAccountPanel.setLayout(new GridLayout(3, 1));
    otherAccountPanel.add(new JLabel("상대 계좌"));
    otherAccountPanel.add(new JLabel("계좌 번호 : " + account.otherAccountIdentifier()));
    otherAccountPanel.add(new JLabel("잔액 : " + account.otherAccountAmount()));
  }
}
