import javax.swing.*;
import java.awt.*;

public class MakaoBank {
  private JFrame frame;
  private JPanel contentPanel;

  private Account account;

  public static void main(String[] args) {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public void run() {
    account = new Account();

    frame = new JFrame("Makao Bank");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 300);
    frame.setLocation(150, 150);

    initButtonsPanel();
    initContentPanel();

    frame.setVisible(true);
  }

  public void initButtonsPanel() {
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new FlowLayout());

    buttonsPanel.add(createAmountButton());
    buttonsPanel.add(createTransferButton());
    buttonsPanel.add(createTransactionsButton());

    frame.add(buttonsPanel, BorderLayout.PAGE_START);
  }

  public JButton createAmountButton() {
    JButton button = new JButton("잔액 조회");

    button.addActionListener(event -> {
      JPanel amountPanel = new AmountPanel(account);

      updateContentPanel(amountPanel);
    });

    return button;
  }

  public JButton createTransferButton() {
    JButton button = new JButton("송금");

    button.addActionListener(event -> {
      JPanel transferPanel = new TransferPanel(account);

      updateContentPanel(transferPanel);
    });

    return button;
  }

  public JButton createTransactionsButton() {
    JButton button = new JButton("거래 내역");

    button.addActionListener(event -> {
      JPanel transactionsPanel = new TransactionsPanel(account);

      updateContentPanel(transactionsPanel);
    });

    return button;
  }

  public void updateContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    frame.add(contentPanel);
  }
}
