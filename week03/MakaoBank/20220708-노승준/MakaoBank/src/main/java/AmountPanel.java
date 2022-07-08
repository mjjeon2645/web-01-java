import javax.swing.*;
import java.awt.*;

public class AmountPanel extends JPanel {
  private Account account;

  AmountPanel(Account account) {
    this.account = account;
    this.setLayout(new GridLayout(2, 1));

    JPanel myAccountPanel = new JPanel();
    myAccountPanel.setLayout(new GridLayout(3,1));
    myAccountPanel.add(new JLabel("내 계좌"));
    myAccountPanel.add(new JLabel("계좌번호: " + account.getMyAccountNumber()));
    myAccountPanel.add(new JLabel("잔액: " + account.getMyAmount() + "원"));
    this.add(myAccountPanel);

    JPanel counterpartAccountPanel = new JPanel();
    counterpartAccountPanel.setLayout(new GridLayout(3, 1));
    counterpartAccountPanel.add(new JLabel("상대 계좌"));
    counterpartAccountPanel.add(new JLabel("계좌번호: " +
        account.getCounterpartAccountNumber()));
    counterpartAccountPanel.add(new JLabel("잔액: " +
        account.getCounterpartAmount() + "원"));
    this.add(counterpartAccountPanel);

  }
}
