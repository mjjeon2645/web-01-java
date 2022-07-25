import javax.swing.*;
import java.awt.*;

public class AmountPanel extends JPanel {
  public AmountPanel(
      AccountRepository accountRepository,
      String myAccountIdentifier, String otherAccountIdentifier) {
    Account myAccount = accountRepository.find(myAccountIdentifier);
    Account otherAccount = accountRepository.find(otherAccountIdentifier);

    this.setLayout(new GridLayout(0, 1));

    this.add(new JLabel("내 계좌"));
    this.add(new JLabel("계좌 번호: " + myAccount.identifier()));
    this.add(new JLabel("잔액: " + myAccount.amount()));

    this.add(new JLabel("상대 계좌"));
    this.add(new JLabel("계좌 번호: " + otherAccount.identifier()));
    this.add(new JLabel("잔액: " + otherAccount.amount()));
  }
}
