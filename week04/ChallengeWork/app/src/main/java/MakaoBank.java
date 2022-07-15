import models.Account;
import panels.TransactionPanel;
import panels.AmountPanel;
import panels.TransferPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MakaoBank {
  private final Account myAccount;
  private final Account otherAccount;
  private final MyTransactionFileLoader myTransactionFileLoader;
  private final OtherTransactionFileLoader otherTranasctionFileLoader;

  private JFrame frame;
  private JPanel contentPanel;

  public static void main(String[] args) throws FileNotFoundException {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public MakaoBank() throws FileNotFoundException {
    myAccount = new Account("123-456", 3000);
    otherAccount = new Account("345-678", 1000);
    myTransactionFileLoader = new MyTransactionFileLoader(myAccount.transactions());
    otherTranasctionFileLoader = new OtherTransactionFileLoader(otherAccount.transactions());
  }

  private void run() {
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 500);

    initMenu();

    initContentPanel();

    saveMyTransactions();
    saveOtherTransactions();

    frame.setVisible(true);
  }

  public void initMenu() {
    JPanel panel = new JPanel();
    frame.add(panel, BorderLayout.PAGE_START);

    panel.add(createAmountButton());
    panel.add(createTransferButton());
    panel.add(createTransactionButton());
  }

  public JButton createAmountButton() {
    JButton button = new JButton("잔액조회");
    button.addActionListener(event -> {
      JPanel amountPanel = new AmountPanel(myAccount, otherAccount);
      showContentPanel(amountPanel);
    });
    return button;
  }

  public JButton createTransferButton() {
    JButton button = new JButton("송금");
    button.addActionListener(event -> {
      JPanel transferPanel = new TransferPanel(myAccount, otherAccount);
      showContentPanel(transferPanel);
    });
    return button;
  }

  public JButton createTransactionButton() {
    JButton button = new JButton("거래내역");
    button.addActionListener(event -> {
      JPanel transactionPanel = new TransactionPanel(myAccount, otherAccount);
      showContentPanel(transactionPanel);
    });
    return button;
  }

  public void initContentPanel() {
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

  public void saveMyTransactions() {
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        try {
          MyTransactionFileWriter myTransactionFileWriter =
              new MyTransactionFileWriter(myAccount.transactions());
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
          otherTransactionFileWriter otherTransactionFileWriter =
              new otherTransactionFileWriter(otherAccount.transactions());
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
  }
}
