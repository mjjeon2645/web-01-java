// amountcheck,  transaction, transfer -> panel
// contentpanel <- amountpanel, ...

import javax.swing.*;
import java.awt.*;

public class MakaoBank {
  private Account account;

  private JPanel contentPanel;
  private JFrame frame;
  private JPanel menuPanel;

  public static void main(String[] args) {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public void run() {
    account = new Account();
    frame = new JFrame("MakaoBank");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(Color.CYAN);
    //frame.getJMenuBar().setBackground(Color.RED);
    frame.setSize(400, 700);

    initMenuPanel();
    initContentPanel();

    frame.setVisible(true);

  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    frame.add(contentPanel);
  }

  public void initMenuPanel() {
    menuPanel = new JPanel();
    menuPanel.setLayout(new FlowLayout());
    menuPanel.setBackground(Color.ORANGE);

    menuPanel.add(createAmountButton());
    menuPanel.add(createTransferButton());
    menuPanel.add(createTransactionButton());

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

  public JButton createTransactionButton() {
    JButton button = new JButton("거래내역");
    button.addActionListener(event -> {
      JPanel transactionPanel = new TransactionPanel(account);
      showContentPanel(transactionPanel);
    });
    return button;
  }

  public void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }
}
