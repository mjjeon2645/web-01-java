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
    frame.setSize(400, 600);

    initMenu();

    initContentPanel();

    frame.setVisible(true);
  }

  public void initMenu() {
    JPanel panel = new JPanel();
    frame.add(panel, BorderLayout.PAGE_START);

    panel.add(initAmountButton());
    panel.add(initTransferButton());
    panel.add(initTransactionsButton());
  }

  public JButton initAmountButton() {
    JButton button = new JButton("잔액 조회");
    button.addActionListener(event -> {
      // amountPanel
      AmountPanel amountPanel = new AmountPanel(account);
      displayContentPanel(amountPanel);
    });
    return button;
  }

  public JButton initTransferButton() {
    JButton button = new JButton("송금");
    button.addActionListener(event -> {
      // transferPanel
      TransferPanel transferPanel = new TransferPanel(account);
      displayContentPanel(transferPanel);
    });
    return button;
  }

  public JButton initTransactionsButton() {
    JButton button = new JButton("거래 내역");
    button.addActionListener(event -> {
      //transactionsPanel
      TransactionsPanel transactionsPanel = new TransactionsPanel(account);
      displayContentPanel(transactionsPanel);
    });
    return button;
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    frame.add(contentPanel);
  }

  public void displayContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }
}
