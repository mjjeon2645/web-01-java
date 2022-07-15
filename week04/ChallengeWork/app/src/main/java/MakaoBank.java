import models.Account;
import panels.TransactionPanel;
import panels.AmountPanel;
import panels.TransferPanel;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class MakaoBank {
  private final Account myAccount;
  private final Account otherAccount;
  private final MyTransactionFileLoader myTransactionFileLoader;
  private final OtherTransactionFileLoader otherTrnasctionFileLoader;

  private JFrame frame;
  private JPanel contentPanel;

  public static void main(String[] args) throws FileNotFoundException {
    MakaoBank application = new MakaoBank();
    application.run();
  }
  public MakaoBank() throws FileNotFoundException {
    myAccount = new Account("123-456",3000);
    otherAccount = new Account("345-678",1000);
    myTransactionFileLoader = new MyTransactionFileLoader(myAccount.transactions());
    otherTrnasctionFileLoader = new OtherTransactionFileLoader(otherAccount.transactions());
  }

  private void run() {
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,500);

    initMenu();
    initContentPanel();

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
      JPanel amountPanel = new AmountPanel(myAccount,otherAccount);
      showContentPanel(amountPanel);
    });
    return button;
  }

  public JButton createTransferButton() {
    JButton button = new JButton("송금");
    button.addActionListener(event -> {
      JPanel transferPanel = new TransferPanel(myAccount,otherAccount);
      showContentPanel(transferPanel);
    });
    return button;
  }

  public JButton createTransactionButton() {
    JButton button = new JButton("거래내역");
    button.addActionListener(event -> {
      JPanel transactionPanel = new TransactionPanel(myAccount,otherAccount);
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
}
