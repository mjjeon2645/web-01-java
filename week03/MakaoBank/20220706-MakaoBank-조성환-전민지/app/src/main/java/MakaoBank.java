// 잔액조회 , 송금 , 거래내역
// 각각의 버튼 만들어 주기
// 패널을 2개 만들어서 버튼이 있는 패널과 결과를 보여주는 패널로 분리하기

import javax.swing.*;
import java.awt.*;

public class MakaoBank {
  private Account account;

  private JFrame frame;
  private JPanel contentPanel;
  private JPanel panel;

  public static void main(String[] args) {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  private void run() {
    account = new Account();

    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);

    initMenu();

    initContentPanel();

    frame.setVisible(true);
  }

  private void initMenu() {
    panel = new JPanel();
    frame.add(panel, BorderLayout.PAGE_START);

    panel.add(createAmountButton());
    panel.add(createTransferButton());
    panel.add(createTransactionsButton());
  }

  public JButton createAmountButton() {
    JButton button = new JButton("잔액 조회");
    button.addActionListener(event -> {
      AmountPanel amountPanel = new AmountPanel(account);

      showContentPanel(amountPanel);
    });
    return button;
  }

  public JButton createTransferButton() {
    JButton button = new JButton("송금");
    button.addActionListener(event -> {
      TransferPanel transferPanel = new TransferPanel(account);
      showContentPanel(transferPanel);
    });
    return button;
  }

  public JButton createTransactionsButton() {
    JButton button = new JButton("거래 내역");
    button.addActionListener(event -> {
      TransactionsPanel transactionsPanel = new TransactionsPanel(account);
      showContentPanel(transactionsPanel);
    });
    return button;
  }

  private void initContentPanel() {
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
