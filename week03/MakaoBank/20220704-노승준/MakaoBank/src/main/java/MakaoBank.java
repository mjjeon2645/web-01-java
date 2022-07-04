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
    frame = new JFrame("Makao Bank");
    frame.setSize(500, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    initButton();
    initContentPanel();

    frame.setVisible(true);
  }

  public void initButton() {
    account = new Account();

    JPanel panel = new JPanel();
    frame.add(panel, BorderLayout.PAGE_START);
    panel.add(createAmountButton());
    panel.add(createTransferButton());
    panel.add(createTransactionButton());
  }

  public JButton createAmountButton() {
    JButton button = new JButton("잔액 조회");
    button.addActionListener(event -> {
      JPanel amountpanel = new Amountpanel(account);
      showContentPanel(amountpanel);
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

  public JButton createTransactionButton() {
    JButton button = new JButton("거래 내역");
    button.addActionListener(event -> {
      JPanel transactionPanel = new TransactionPanel(account);
      showContentPanel(transactionPanel);
    });
    return button;
  }

  private void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    frame.add(contentPanel);
  }
}
