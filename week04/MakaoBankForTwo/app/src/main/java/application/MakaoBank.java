package application;

import models.Account;
import panels.AmountPanel;
import panels.TransactionsPanel;
import panels.TransferPanel;
import utils.MyTransactionsLoader;
import utils.MyTransactionsSaver;
import utils.OtherTransactionsLoader;
import utils.OtherTransactionsSaver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MakaoBank {
  private Account myAccount;
  private Account otherAccount;

  private JFrame frame;
  private JPanel menuPanel;
  private JPanel contentPanel;

  public static void main(String[] args) throws FileNotFoundException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public MakaoBank() throws FileNotFoundException {
    MyTransactionsLoader myTransactionsLoader = new MyTransactionsLoader();
    OtherTransactionsLoader otherTransactionsLoader = new OtherTransactionsLoader();

    this.myAccount = myTransactionsLoader.accountLoader();
    this.otherAccount = otherTransactionsLoader.accountLoader();
  }

  public void run() {
    initFrame();

    initMenu();

    initContentPanel();

    saveMyTransactions();
    saveOtherTransactions();
  }

  public void initFrame() {
    frame = new JFrame("Makao Bank");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 600);
    frame.setVisible(true);
  }

  public void initMenu() {
    menuPanel = new JPanel();
    frame.add(menuPanel, BorderLayout.PAGE_START);

    menuPanel.add(amountButton());
    menuPanel.add(transferButton());
    menuPanel.add(transactionsButton());
  }

  public JButton amountButton() {
    JButton button = new JButton("잔액 조회");
    button.addActionListener(event -> {
      AmountPanel amountPanel = new AmountPanel(myAccount, otherAccount);
      showContentPanel(amountPanel);
    });
    return button;
  }

  public JButton transferButton() {
    JButton button = new JButton("계좌 이체");
    button.addActionListener(event -> {
      TransferPanel transferPanel = new TransferPanel(myAccount, otherAccount);
      showContentPanel(transferPanel);
    });
    return button;
  }

  public JButton transactionsButton() {
    JButton button = new JButton("거래 내역");
    button.addActionListener(event -> {
      TransactionsPanel transactionsPanel = new TransactionsPanel(myAccount, otherAccount);
      showContentPanel(transactionsPanel);
    });
    return button;
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

    frame.add(contentPanel);
  }

  public void saveMyTransactions() {
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        try {
          MyTransactionsSaver myTransactionsSaver = new MyTransactionsSaver(myAccount);
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
  }

  public void saveOtherTransactions() {
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        try {
          OtherTransactionsSaver otherTransactionsSaver = new OtherTransactionsSaver(otherAccount);
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
  }
}
