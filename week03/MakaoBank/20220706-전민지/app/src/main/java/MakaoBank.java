import javax.swing.*;
import java.awt.*;

public class MakaoBank {
  private Account account;

  private JFrame frame;
  private JPanel panel;
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

    panel = new JPanel();
    frame.add(panel, BorderLayout.PAGE_START);

    frame.setVisible(true);

    initMenu();

    initContentPanel();
  }

  public void initMenu() {
    panel.add(createAmountButton());
    panel.add(createTransferButton());
    panel.add(createTransactionsButton());
  }

  public JButton createAmountButton() {
    JButton button = new JButton("잔액 조회");
    button.addActionListener(event -> {
      AmountPanel amountPanel = new AmountPanel(account);
      contentPanel.add(amountPanel);
      showContentPanel(amountPanel);
    });

    return button;
  }

  public JButton createTransferButton() {
    JButton button = new JButton("송금");
    button.addActionListener(event -> {
      TransferPanel transferPanel = new TransferPanel(account);
      contentPanel.add(transferPanel);
      showContentPanel(transferPanel);
    });

    return button;
  }

  public JButton createTransactionsButton() {
    JButton button = new JButton("거래 내역");
    button.addActionListener(event -> {
      TransactionsPanel transactionsPanel = new TransactionsPanel(account);
      contentPanel.add(transactionsPanel);
      showContentPanel(transactionsPanel);
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
