import javax.swing.*;
import java.awt.*;

public class MakaoBank {
  Account account = new Account();

  private JFrame frame;
  private JPanel buttonsPanel;
  private JPanel contentPanel;

  public static void main(String[] args) {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public void run() {
    createFrame();
    initButtonsPanel();
    initContentPanel();

    frame.setVisible(true);
  }

  public void createFrame() {
    frame = new JFrame("Makao Bank");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 600);
    frame.setLocation(150, 150);
  }

  public void initButtonsPanel() {
    buttonsPanel = new JPanel();

    buttonsPanel.add(createAmountButton());
    buttonsPanel.add(createTransferButton());
    buttonsPanel.add(createTransactionsButton());

    frame.add(buttonsPanel, BorderLayout.PAGE_START);
  }

  public JButton createAmountButton() {
    JButton amountButton = new JButton("잔액 조회");
    amountButton.addActionListener(event -> {
      JPanel amountPanel = new AmountPanel(account);

      showContentPanel(amountPanel);
    });
    return amountButton;
  }

  public JButton createTransferButton() {
    JButton transferButton = new JButton("송금");
    transferButton.addActionListener(event -> {
      JPanel transferPanel = new TransferPanel(account);

      showContentPanel(transferPanel);
    });
    return transferButton;
  }

  public JButton createTransactionsButton() {
    JButton transactionsButton = new JButton("거래 내역");
    transactionsButton.addActionListener(event -> {
      JPanel transactionsPanel = new TransactionsPanel(account);

      showContentPanel(transactionsPanel);
    });
    return transactionsButton;
  }

  private void showContentPanel(JPanel panel) {
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
