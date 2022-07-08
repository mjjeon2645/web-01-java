import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class AmountPanel extends JPanel {

  AmountPanel(Account account) {

    this.setLayout(new GridLayout(2, 1));

    initAmountInformationOfMine(account);

    initAmountInformationOfOthers(account);
  }

  public void initAmountInformationOfMine(Account account) {
    JPanel amountPanelOfMine = new JPanel();
    amountPanelOfMine.setLayout(new GridLayout(3, 1));
    amountPanelOfMine.setBorder(new LineBorder(Color.BLACK, 3));

    JLabel titleOfMineLabel = new JLabel("내 계좌");
    amountPanelOfMine.add(titleOfMineLabel);

    JLabel identifierOfMineLabel = new JLabel("계좌 번호: " + account.identifierOfMine());
    amountPanelOfMine.add(identifierOfMineLabel);

    JLabel amountOfMineLabel = new JLabel("잔액: " + account.amountOfMine() + "원");
    amountPanelOfMine.add(amountOfMineLabel);

    this.add(amountPanelOfMine);
  }

  public void initAmountInformationOfOthers(Account account) {
    JPanel amountPanelOfOthers = new JPanel();
    amountPanelOfOthers.setLayout(new GridLayout(3, 1));
    amountPanelOfOthers.setBorder(new LineBorder(Color.BLACK, 3));

    JLabel titleOfOthersLabel = new JLabel("상대 계좌");
    amountPanelOfOthers.add(titleOfOthersLabel);

    JLabel identifierOfOthersLabel = new JLabel("계좌 번호: " + account.identifierOfOthers());
    amountPanelOfOthers.add(identifierOfOthersLabel);

    JLabel amountOfOthersLabel = new JLabel("잔액: " + account.amountOfOthers() + "원");
    amountPanelOfOthers.add(amountOfOthersLabel);

    this.add(amountPanelOfOthers);
  }
}
