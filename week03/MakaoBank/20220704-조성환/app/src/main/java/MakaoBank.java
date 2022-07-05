import javax.swing.*;
import java.awt.*;

public class MakaoBank {
  private JFrame frame;
  private JPanel contentPanel;
  Account account;

  public static void main(String[] args){
    MakaoBank application = new MakaoBank();
    application.run();
  }

  private void run() {
    account = new Account();

    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,300);

    initMenuPanel();
    initContentPanel();

    frame.setVisible(true);
  }

  private void initMenuPanel() {
     JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());
    frame.add(panel, BorderLayout.PAGE_START);

    panel.add(amountButton());
    panel.add(transferButton());
    panel.add(transactionButton());
  }

  public JButton amountButton() {
    JButton button = new JButton("잔액조회");
    button.addActionListener(event -> {
        AmountPanel amountPanel = new AmountPanel(account);
      showContentPanel(amountPanel);

    });
    return button;
  }

  public JButton transferButton() {
    JButton button = new JButton("송금");
    button.addActionListener(event -> {
      TransferPanel transferPanel = new TransferPanel(account);
      showContentPanel(transferPanel);
    });
    return button;
  }

  public JButton transactionButton() {
    JButton button = new JButton("거래 내역");
    button.addActionListener(event -> {
        TransactionPanel transactionPanel = new TransactionPanel(account);
        showContentPanel(transactionPanel);
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
  }

}
