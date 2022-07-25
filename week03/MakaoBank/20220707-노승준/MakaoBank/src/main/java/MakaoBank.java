import javax.swing.*;
import java.awt.*;

public class MakaoBank {
  private JPanel panel;
  private JFrame frame;
  private JPanel contentPanel;

  private Account account = new Account();

  public static void main(String[] args) {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public void run() {

    frame = new JFrame("MakaoBank");
    frame.setSize(500, 700);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    initMenuButtons();

    initContentPanel();

    frame.setVisible(true);
  }

  private void initMenuButtons() {
    panel = new JPanel();
    frame.add(panel, BorderLayout.PAGE_START);

    panel.add(createAmountButton());
    panel.add(createTransferButton());
    panel.add(createTransactionButton());
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    frame.add(contentPanel);
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
      JPanel transacferPanel = new TransferPanel(account);
      showContentPanel(transacferPanel);
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

  private void showContentPanel(JPanel amountPanel) {
    contentPanel.removeAll();
    contentPanel.add(amountPanel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }
}
