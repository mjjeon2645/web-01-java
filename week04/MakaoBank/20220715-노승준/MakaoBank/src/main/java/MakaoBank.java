import models.Account;
import panels.AmountPanel;
import panels.TransactionPanel;
import panels.TransferPanel;
import utils.MyTransactionLoader;
import utils.MyTransactionWriter;
import utils.OtherTransactionLoader;
import utils.OtherTransactionWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MakaoBank {
  private JFrame frame;

  private JPanel contentPanel;
  private Account account = new Account();

  public static void main(String[] args) throws FileNotFoundException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public MakaoBank() throws FileNotFoundException {
    MyTransactionLoader transactionLoader = new MyTransactionLoader();
    OtherTransactionLoader otherTransactionLoader = new OtherTransactionLoader();

    account.myTransactions = transactionLoader.loadMyTransaction();
    account.otherTransactions = otherTransactionLoader.loadOtherTransaction();
  }

  public void run() {
    frame = new JFrame("Makao Bank");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 600);

    initMenuButtons();
    initContentPanel();

    myTransactionWriter();
    otherTransactionWriter();

    frame.setVisible(true);
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    frame.add(contentPanel);
  }

  public void initMenuButtons() {
    JPanel menuPanel = new JPanel();
    frame.add(menuPanel, BorderLayout.PAGE_START);

    menuPanel.add(createAmountButton());
    menuPanel.add(createTransferButton());
    menuPanel.add(createTransactionButton());
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
    JButton transferButton = new JButton("계좌 이체");
    transferButton.addActionListener(event -> {
      JPanel transferPanel = new TransferPanel(account);
      showContentPanel(transferPanel);
    });

    return transferButton;
  }

  public JButton createTransactionButton() {
    JButton transactionButton = new JButton("거래 내역");
    transactionButton.addActionListener(event -> {
      JPanel transactionPanel = new TransactionPanel(account);
      showContentPanel(transactionPanel);
    });

    return transactionButton;
  }

  public void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }

  public void myTransactionWriter() {
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent event) {
        MyTransactionWriter transactionWriter = new MyTransactionWriter();

        try {
          transactionWriter.writeTransaction(account ,account.myTransactions);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  public void otherTransactionWriter() {
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent event) {
        OtherTransactionWriter otherTransactionWriter =
            new OtherTransactionWriter();

        try {
          otherTransactionWriter.writeTransaction(
              account,
              account.otherTransactions);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    });
  }
}
