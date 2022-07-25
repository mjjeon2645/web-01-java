import javax.swing.*;
import java.awt.*;

public class MakaoBank {
  private Account account;

  private JFrame frame;
  private JPanel menuPanel;
  private JPanel contentPanel;

  public static void main(String[] args) {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public void run() {
    account = new Account();

    frame = new JFrame("Makao bank");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 600);
    frame.setLocation(100 ,70);

    initMenu();
    initContentPanel();

    frame.setVisible(true);
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    frame.add(contentPanel);
  }

  public void initMenu() {
    menuPanel = new JPanel();

    menuPanel.add(createAmountButton());
    menuPanel.add(createTransferButton());
    menuPanel.add(createTransactionsButton());

    frame.add(menuPanel, BorderLayout.PAGE_START);
  }

  public JButton createAmountButton() {
    JButton button = new JButton("잔액 조회");
    button.addActionListener(event -> {
      JPanel amountPanel = new AmountPanel(account);
      showContentPanel(amountPanel);
    });
    return button;
  }

  public JButton createTransferButton() {
    JButton button = new JButton("송금");
    button.addActionListener(event -> {
      JPanel transferPanel = new TransferPanel(account);
      showContentPanel(transferPanel);
    });
    return button;
  }

  public JButton createTransactionsButton() {
    JButton button = new JButton("거래 내역");
    button.addActionListener(event -> {
      JPanel transactionsPanel = new TransactionsPanel(account);
      showContentPanel(transactionsPanel);
    });
    return button;
  }

  public void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }
}
