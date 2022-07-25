import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TransferPanel extends JPanel {
  private Account account;

  private JPanel myTransferPanel;
  private JPanel theOtherTransferPanel;

  public TransferPanel(Account account) {
    this.account = account;

    this.setLayout(new GridLayout(2, 1));

    transferToTheOther();

    transferToMe();
  }

  public void transferToTheOther() {
    myTransferPanel = new JPanel();

    myTransferPanel.setLayout(new GridLayout(4, 2, 10, 10));
    myTransferPanel.setBorder(new LineBorder(Color.BLACK, 3));

    JLabel titleLabel1 = new JLabel("내 계좌에서 송금하기");
    myTransferPanel.add(titleLabel1);

    JLabel layoutLabel1 = new JLabel("    ");
    myTransferPanel.add(layoutLabel1);

    JLabel identifierLabel1 = new JLabel("계좌 번호: ");
    myTransferPanel.add(identifierLabel1);

    JTextField toIdentifier = new JTextField(5);
    myTransferPanel.add(toIdentifier);

    JLabel amountLabel1 = new JLabel("금액: ");
    myTransferPanel.add(amountLabel1);

    JTextField amountToTheOther = new JTextField(5);
    myTransferPanel.add(amountToTheOther);

    JLabel layoutLabel2 = new JLabel("    ");
    myTransferPanel.add(layoutLabel2);

    JButton sendToOthersButton = new JButton("송금");
    sendToOthersButton.addActionListener(event -> {
      long transferAmountToTheOther = Long.parseLong(amountToTheOther.getText());
      if (toIdentifier.getText().equals(account.theOtherIdentifier())) {
        account.transferToTheOther(transferAmountToTheOther);
      }
    });
    myTransferPanel.add(sendToOthersButton);

    this.add(myTransferPanel);
  }

  public void transferToMe() {
    theOtherTransferPanel = new JPanel();
    theOtherTransferPanel.setLayout(new GridLayout(4, 2, 10, 10));
    theOtherTransferPanel.setBorder(new LineBorder(Color.BLACK, 3));

    JLabel titleLabel2 = new JLabel("상대 계좌에서 입금하기");
    theOtherTransferPanel.add(titleLabel2);

    JLabel layoutLabel3 = new JLabel("    ");
    theOtherTransferPanel.add(layoutLabel3);

    JLabel identifierLabel2 = new JLabel("계좌 번호: ");
    theOtherTransferPanel.add(identifierLabel2);

    JTextField fromIdentifier = new JTextField(5);
    theOtherTransferPanel.add(fromIdentifier);

    JLabel amountLabel2 = new JLabel("금액: ");
    theOtherTransferPanel.add(amountLabel2);

    JTextField amountToMe = new JTextField(5);
    theOtherTransferPanel.add(amountToMe);

    JLabel layoutLabel4 = new JLabel("    ");
    theOtherTransferPanel.add(layoutLabel4);

    JButton sendToMeButton = new JButton("입금");
    sendToMeButton.addActionListener(event -> {
      long transferAmountToMe = Long.parseLong(amountToMe.getText());
      if (fromIdentifier.getText().equals(account.theOtherIdentifier())) {
        account.transferToMe(transferAmountToMe);
      }
    });

    theOtherTransferPanel.add(sendToMeButton);

    this.add(theOtherTransferPanel);
  }
}
