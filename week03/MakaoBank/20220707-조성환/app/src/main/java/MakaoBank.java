import javax.swing.*;
import java.awt.*;

public class MakaoBank {
  private JPanel panel;
  private JFrame frame;
  private JPanel contentPanel;
  private Account account;

  public static void main(String[] args) {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  private void run() {
    account = new Account();
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);

    initMenuPanel();
    initContentPanel();

    frame.setVisible(true);
  }

  private void initMenuPanel() {
    panel = new JPanel();
    frame.add(panel , BorderLayout.PAGE_START);


    panel.add(createAmountButton());
    panel.add(createTransferButton());
    panel.add(createTransactionButton());
  }

  private JButton createAmountButton() {
    JButton button = new JButton("잔액조회");
    button.addActionListener(event -> {
      JPanel amountPanel = new AmountPanel(account);
      showContentPanel(amountPanel);
    });
    return button;
  }

  private JButton createTransferButton() {
    JButton button = new JButton("송금");
    button.addActionListener(event -> {
      JPanel TransferPanel = new TransferPanel(account);
      showContentPanel(TransferPanel);
    });
    return button;
  }

  private JButton createTransactionButton() {
    JButton button = new JButton("거래내역");
    button.addActionListener(event -> {
      JPanel transactionsPanel = new TransactionsPanel(account);
      showContentPanel(transactionsPanel);
    });
    return button;
  }

  private void initContentPanel() {
    contentPanel = new JPanel();
    frame.add(contentPanel);
  }

  private void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }
}
