import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TransferPanel extends JPanel {
  private Account account;
  private final JPanel transferPanelOfMine;

  public TransferPanel(Account account) {
    this.account = account;
    this.setLayout(new GridLayout(2, 1));

    transferPanelOfMine = new JPanel();
    transferPanelOfMine.setLayout(new GridLayout(4, 2));
    transferPanelOfMine.setBorder(new LineBorder(Color.BLACK, 3));

    transferFromIToOthers();

    transferFromOthersToMe();
  }

  public void transferFromIToOthers() {
    JLabel titleOfMineLabel = new JLabel("내 계좌에서 송금하기");
    transferPanelOfMine.add(titleOfMineLabel);

    JLabel nullLabel1 = new JLabel("    ");
    transferPanelOfMine.add(nullLabel1);

    JLabel identifierOfMineLabel = new JLabel("계좌 번호: ");
    transferPanelOfMine.add(identifierOfMineLabel);

    JTextField identifierToTransferTextField = new JTextField(5);
    transferPanelOfMine.add(identifierToTransferTextField);

    JLabel transferAmountOfMineLabel = new JLabel("금액: ");
    transferPanelOfMine.add(transferAmountOfMineLabel);

    JTextField transferAmountOfMineTextField = new JTextField(5);
    transferPanelOfMine.add(transferAmountOfMineTextField);

    JLabel nullLabel2 = new JLabel("    ");
    transferPanelOfMine.add(nullLabel2);

    JButton sendToOthersButton = new JButton("송금");
    sendToOthersButton.addActionListener(event -> {
      long amountToOthers = Long.parseLong(transferAmountOfMineTextField.getText());
      if (identifierToTransferTextField.getText().equals(account.identifierOfOthers())) {
        account.transferToOthers(amountToOthers);
      }
    });
    transferPanelOfMine.add(sendToOthersButton);

    this.add(transferPanelOfMine);
  }

  public void transferFromOthersToMe() {
    JPanel transferPanelOfOthers = new JPanel();
    transferPanelOfOthers.setLayout(new GridLayout(4, 2));
    transferPanelOfOthers.setBorder(new LineBorder(Color.BLACK, 3));

    JLabel titleOfOthersLabel = new JLabel("상대 계좌에서 입금하기");
    transferPanelOfOthers.add(titleOfOthersLabel);

    JLabel nullLabel3 = new JLabel("    ");
    transferPanelOfOthers.add(nullLabel3);

    JLabel identifierOfOtherLabel = new JLabel("계좌 번호: ");
    transferPanelOfOthers.add(identifierOfOtherLabel);

    JTextField identifierOfOthersTextField = new JTextField(5);
    transferPanelOfOthers.add(identifierOfOthersTextField);

    JLabel transferAmountOfOtherLabel = new JLabel("금액: ");
    transferPanelOfOthers.add(transferAmountOfOtherLabel);

    JTextField transferAmountToMeTextField = new JTextField(5);
    transferPanelOfOthers.add(transferAmountToMeTextField);

    JLabel nullLabel4 = new JLabel("    ");
    transferPanelOfOthers.add(nullLabel4);

    JButton sendToMeButton = new JButton("입금");
    sendToMeButton.addActionListener(event -> {
      long amountToMe = Long.parseLong(transferAmountToMeTextField.getText());
      if (identifierOfOthersTextField.getText().equals(account.identifierOfOthers())) {
        account.transferToMe(amountToMe);
      }
    });

    transferPanelOfOthers.add(sendToMeButton);

    this.add(transferPanelOfOthers);
  }

}
