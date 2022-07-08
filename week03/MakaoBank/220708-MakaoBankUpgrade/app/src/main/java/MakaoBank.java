import Panels.*;
import models.*;

import javax.swing.*;
import java.awt.*;

public class MakaoBank {
  private Account myAccount = new Account("123-456-7890",3000);
  private Account yourAccount = new Account("345-678-9012",1000);

  private JFrame frame;
  private JPanel contentPanel;

  public static void main(String[] args) {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public void run() {
    frame = new JFrame("MakaoBank");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 600);


    JPanel panel = new JPanel();
    frame.add(panel, BorderLayout.PAGE_START);

    panel.add(createAmountButton());
    panel.add(createTransferButton());
    panel.add(createTransactionButton());

    contentPanel = new JPanel();
    frame.add(contentPanel);
    contentPanel.setBackground(Color.LIGHT_GRAY);

    frame.setVisible(true);
  }

  private JButton createAmountButton() {
    JButton button = new JButton("잔액 조회");
    button.addActionListener(event -> {
      JPanel amountPanel = new AmountPanel(myAccount,yourAccount);
      showContentPanel(amountPanel);

    });

    return button;
  }

  private JButton createTransferButton() {
    JButton button = new JButton("계좌 이체");
    button.addActionListener(event -> {
      JPanel transferPanel = new TransferPanel(myAccount,yourAccount);
      showContentPanel(transferPanel);
    });
    return button;
  }

  private JButton createTransactionButton() {
    JButton button = new JButton("거래 내역");
    button.addActionListener(event -> {

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
