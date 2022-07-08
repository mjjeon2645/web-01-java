import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TransferPanel extends JPanel {
  private Account account;
  private JTextField accountNumber;
  private JTextField accountNumber2;
  private JTextField amount;
  private JTextField amount2;

  TransferPanel(Account account) {
    this.account = account;
    this.setLayout(new GridLayout(2, 1));

    myTransferPanel();
    otherTransferPanel();
  }

  private void myTransferPanel() {
    JPanel transferMyAccount = new JPanel();
    transferMyAccount.setLayout(new GridLayout(6, 1));
    this.add(transferMyAccount);

    transferMyAccount.add(new JLabel("내 계좌에서 송금하기"));
    transferMyAccount.add(new JLabel("계좌 번호"));

    accountNumber = new JTextField(10);
    transferMyAccount.add(accountNumber);

    transferMyAccount.add(new JLabel("금액"));

    amount = new JTextField(10);
    transferMyAccount.add(amount);

    transferMyAccount.add(sendButton());
  }

  private void otherTransferPanel() {
    JPanel transferOtherAccount = new JPanel();
    transferOtherAccount.setLayout(new GridLayout(6, 1));
    this.add(transferOtherAccount);

    transferOtherAccount.add(new JLabel("상대 계좌에서 입금하기"));
    transferOtherAccount.add(new JLabel("계좌 번호"));

    accountNumber2 = new JTextField(10);
    transferOtherAccount.add(accountNumber2);

    transferOtherAccount.add(new JLabel("금액"));

    amount2 = new JTextField(10);
    transferOtherAccount.add(amount2);

    transferOtherAccount.add(depositButton());
  }

  private JButton sendButton() {
    JButton button = new JButton("송금");
    button.addActionListener((event) -> {
      String sendAccountNumber = accountNumber.getText();
      long sendAmount = Long.parseLong(amount.getText());
      account.transfer(sendAccountNumber, sendAmount);
    });
    return button;
  }

  private JButton depositButton() {
    JButton button = new JButton("입금");
    button.addActionListener((event) -> {
      String depositAccountNumber = accountNumber2.getText();
      long depositAmount = Long.parseLong(amount2.getText());
      account.deposit(depositAccountNumber, depositAmount);
    });
    return button;
  }
}
