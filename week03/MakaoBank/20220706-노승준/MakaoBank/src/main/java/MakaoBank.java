import javax.swing.*;
import java.awt.*;

public class MakaoBank {
  private JFrame frame;
  private JPanel panel;
  private JPanel contentPanel;

  private Account account;

  public static void main(String[] args) {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public void run() {
    account = new Account();

    frame = new JFrame("Makao Bank");
    frame.setSize(400, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    initMenu();
    initContentPanel();

    frame.setVisible(true);
  }

  public void initMenu() {
    panel = new JPanel();
    frame.add(panel, BorderLayout.PAGE_START);

    panel.add(createAmountButton());
    panel.add(createTransferButton());
    panel.add(createTransactionButton());
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
      TransferPanel transferPanel = new TransferPanel(account);
      showContentPanel(transferPanel);
    });
    return button;
  }

  public JButton createTransactionButton() {
    JButton button = new JButton("거래 내역");
    button.addActionListener(event -> {
      Transaction transaction = new Transaction(account);
      showContentPanel(transaction);
    });
    return button;
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    frame.add(contentPanel);
  }

  private void showContentPanel(JPanel amountPanel) {
    contentPanel.removeAll();
    contentPanel.add(amountPanel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }
}
