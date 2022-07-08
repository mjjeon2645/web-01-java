import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TransferPanel extends JPanel {
  public TransferPanel(Account account) {

    this.setLayout(new GridLayout(2, 1));

  //TODO. 내 계좌에서 송금하기 패널, 상대 계좌에서 입금하기 패널이 보여야 함. (그리드 레이아웃)

    JPanel transferPanelOfMine = new JPanel();
    transferPanelOfMine.setLayout(new GridLayout(4, 2));
    transferPanelOfMine.setBorder(new LineBorder(Color.BLACK, 3));

    JLabel titleOfMineLabel = new JLabel("내 계좌에서 송금하기");
    transferPanelOfMine.add(titleOfMineLabel);

    JLabel nullLabel1 = new JLabel("    ");
    transferPanelOfMine.add(nullLabel1);

    JLabel identifierOfMineLabel = new JLabel("계좌 번호: ");
    transferPanelOfMine.add(identifierOfMineLabel);

    JTextField identifierOfMineTextField = new JTextField(5);
    transferPanelOfMine.add(identifierOfMineTextField);

    JLabel transferAmountOfMineLabel = new JLabel("금액: ");
    transferPanelOfMine.add(transferAmountOfMineLabel);

    JTextField transferAmountOfMineTextField = new JTextField(5);
    transferPanelOfMine.add(transferAmountOfMineTextField);

    JLabel nullLabel2 = new JLabel("    ");
    transferPanelOfMine.add(nullLabel2);

    JButton sendToOthersButton = new JButton("송금");
    transferPanelOfMine.add(sendToOthersButton);

    this.add(transferPanelOfMine);


    JPanel transferPanelOfOthers = new JPanel();
    transferPanelOfOthers.setLayout(new GridLayout(4, 2));
    transferPanelOfOthers.setBorder(new LineBorder(Color.BLACK, 3));

    JLabel titleOfOthersLabel = new JLabel("상대 계좌에서 입금하기");
    transferPanelOfOthers.add(titleOfOthersLabel);

    JLabel nullLabel3 = new JLabel("    ");
    transferPanelOfOthers.add(nullLabel3);

    JLabel identifierOfOtherLabel = new JLabel("계좌 번호: ");
    transferPanelOfOthers.add(identifierOfOtherLabel);

    JTextField identifierOfOtherTextField = new JTextField(5);
    transferPanelOfOthers.add(identifierOfOtherTextField);

    JLabel transferAmountOfOtherLabel = new JLabel("금액: ");
    transferPanelOfOthers.add(transferAmountOfOtherLabel);

    JTextField transferAmountOfOtherTextField = new JTextField(5);
    transferPanelOfOthers.add(transferAmountOfOtherTextField);

    JLabel nullLabel4 = new JLabel("    ");
    transferPanelOfOthers.add(nullLabel4);


    JButton sendToMeButton = new JButton("입금");
    transferPanelOfOthers.add(sendToMeButton);

    this.add(transferPanelOfOthers);
  }

}
