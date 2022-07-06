import org.checkerframework.checker.units.qual.*;

import javax.swing.*;
import java.awt.*;

public class MakaoBank {
  private Account account;

  private JFrame frame;
  private JPanel contentPanel;


  public static void main(String[] args) {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public void run() {
    account = new Account();

    frame = new JFrame("MakaoBank");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500,600);

    initMenu();
    initContentPanel();

    frame.setVisible(true);
  }

  public  void initMenu() {
    JPanel panel = new JPanel();
    frame.add(panel,BorderLayout.PAGE_START);

    panel.add(createAmountButton());
    panel.add(createTransferButton());
    panel.add(createTransactionsButton());

  }

  public JButton createAmountButton() {
    JButton button = new JButton("잔액 확인");
    button.addActionListener(event ->{
      JPanel amountPanel = new AmountPanel(account);
      showContentPanel(amountPanel);
    });
    return button;
  }

  private JButton createTransferButton() {
    JButton button = new JButton("송금");
    button.addActionListener(event ->{
      JPanel transferPanel = new TransferPanel(account);
      showContentPanel(transferPanel);
    });
    return button;
  }

  private JButton createTransactionsButton() {
   JButton button = new JButton("거래 내역");
   button.addActionListener(event ->{
     JPanel transactionPanel = new TransactionsPanel(account);
     showContentPanel(transactionPanel);
   });
    return button;
  }


  public void initContentPanel() {
    contentPanel = new JPanel();
    frame.add(contentPanel);
  }

  public void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }
}
