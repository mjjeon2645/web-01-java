package applications;

import models.Account;
import panels.AmountPanel;
import panels.TransactionsPanel;
import panels.TransferPanel;
import utils.FileReader;
import utils.FileWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MakaoBank {
  private final Account myAccount;
  private final Account otherAccount;

  private JFrame frame;
  private JPanel contentPanel;

  public static void main(String[] args) throws FileNotFoundException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public MakaoBank() throws FileNotFoundException {
    FileReader fileReader = new FileReader();

    myAccount = fileReader.loadAccount("myAccount.csv");
    otherAccount = fileReader.loadAccount("otherAccount.csv");
  }

  public void run() {
    initFrame();
    initMenu();
    initContentPanel();

    frame.setVisible(true);
  }

  public void initFrame() {
    frame = new JFrame("Makao Bank");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setLocation(100, 70);

    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent event) {
        try {
          FileWriter fileWriter = new FileWriter();

          fileWriter.saveAccount(myAccount, "myAccount.csv");
          fileWriter.saveAccount(otherAccount, "otherAccount.csv");
        } catch (IOException exception) {
          throw new RuntimeException(exception);
        }
      }
    });
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
