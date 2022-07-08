//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MakaoBank {
  private JFrame frame;
  private JPanel contentPanel;
  private Account account;

  public MakaoBank() {
  }

  public static void main(String[] args) {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  private void run() {
    this.account = new Account();
    this.frame = new JFrame("MakaoBank");
    this.frame.setDefaultCloseOperation(3);
    this.frame.setSize(400, 600);
    this.initMenuButton();
    this.initContentPanel();
    this.frame.setVisible(true);
  }

  private void initMenuButton() {
    JPanel panel = new JPanel();
    this.frame.add(panel, "First");
    panel.add(this.createAmountButton());
    panel.add(this.createTransferButton());
    panel.add(this.createTransactionButton());
  }

  private JButton createAmountButton() {
    JButton button = new JButton("잔액 조회");
    button.addActionListener((event) -> {
      JPanel amountPanel = new AmountPanel(account);
      this.showContentPanel(amountPanel);
    });
    return button;
  }

  private JButton createTransferButton() {
    JButton button = new JButton("계좌 이체");
    button.addActionListener((event) -> {
      JPanel transferPanel = new TransferPanel(account);
      this.showContentPanel(transferPanel);
    });
    return button;
  }

  private JButton createTransactionButton() {
    JButton button = new JButton("계좌 이체");
    button.addActionListener((event) -> {
      JPanel transactionPanel = new TransactionPanel(account);
      this.showContentPanel(transactionPanel);
    });
    return button;
  }

  private void initContentPanel() {
    this.contentPanel = new JPanel();
    this.frame.add(this.contentPanel);
  }

  private void showContentPanel(JPanel panel) {
    this.contentPanel.removeAll();
    this.contentPanel.add(panel);
    this.contentPanel.setVisible(false);
    this.contentPanel.setVisible(true);
    this.frame.setVisible(true);
  }
}

