package applications;

import models.Account;
import panels.AmountPanel;
import panels.TransactionsPanel;
import panels.TransferPanel;

import javax.swing.*;
import java.awt.*;

public class MakaoBank {
  private final Account myAccount;
  private final Account otherAccount;

  private JFrame frame;
  private JPanel contentPanel;

  public static void main(String[] args) {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public MakaoBank() {
    myAccount = new Account("352-0528-2645-53", 10000);
    otherAccount = new Account("179-20-155318", 5000);
  }

  public void run() {
    frame = new JFrame("Makao Bank");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setLocation(100, 70);
    
    initMenu();
    initContentPanel();

    frame.setVisible(true);
  }

  public void initMenu() {
    JPanel menuPanel = new JPanel();
    
    menuPanel.add(createAmountButton());
    menuPanel.add(createTransferButton());
    menuPanel.add(createTransactionsButton());
    
    frame.add(menuPanel, BorderLayout.PAGE_START);
  }

  public JButton createAmountButton() {
    JButton amountButton = new JButton("잔액 조회");
    amountButton.addActionListener(event -> {
      JPanel amountPanel = new AmountPanel(myAccount, otherAccount);

      showContentPanel(amountPanel);
    });
    
    return amountButton;
  }

  public JButton createTransferButton() {
    JButton transferButton = new JButton("계좌 이체");
    transferButton.addActionListener(event -> {
      JPanel transferPanel = new TransferPanel(myAccount, otherAccount);

      showContentPanel(transferPanel);
    });

    return transferButton;
  }

  public JButton createTransactionsButton() {
    JButton transactionsButton = new JButton("거래 내역");
    transactionsButton.addActionListener(event -> {
      JPanel transactionsPanel = new TransactionsPanel(myAccount, otherAccount);

      showContentPanel(transactionsPanel);
    });

    return transactionsButton;
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
  }
}
