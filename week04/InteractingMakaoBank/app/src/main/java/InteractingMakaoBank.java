//프레임 보더레이아웃 설정
import models.*;
import panels.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class InteractingMakaoBank {
  private JFrame frame;
  private JPanel contentPanel;
  private Account account1 = new Account("123-456-7890",3000);
  private Account account2 = new Account("345-678-9012",1000);

  public static void main(String[] args) throws IOException {
    InteractingMakaoBank application = new InteractingMakaoBank();
    application.run();
  }

  public void run() throws IOException {
    account1.loadFile();

    setFrame();

    JPanel panel = new JPanel();
    frame.add(panel, BorderLayout.PAGE_START);

    panel.add(createAmountButton());

    panel.add(createTransferButton());

    panel.add(createTransactionButton());

    contentPanel = new JPanel();
    frame.add(contentPanel);
    contentPanel.setBackground(Color.LIGHT_GRAY);

    account1.saveFile();

    frame.setVisible(true);





  }

  private void setFrame() {
    frame = new JFrame("Makao Bank");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 600);
  }

  private JButton createAmountButton() {
    JButton button = new JButton("잔액 조회");
    button.addActionListener(event -> {
      JPanel amountPanel = new AmountPanel(account1,account2);
      showContentPanel(amountPanel);
    });
    return button;
  }
  private JButton createTransferButton() {
    JButton button = new JButton("계좌 이체");
    button.addActionListener(event -> {
      JPanel transferPanel = new TransferPanel(account1,account2);
      showContentPanel(transferPanel);
    });
    return button;
  }
  private JButton createTransactionButton() {
    JButton button = new JButton("거래 내역");
    button.addActionListener(event -> {

      JPanel transactionPanel = new TransactionPanel(account1,account2);

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