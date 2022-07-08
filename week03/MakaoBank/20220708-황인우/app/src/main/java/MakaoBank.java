import javax.swing.*;
import java.awt.*;

public class MakaoBank {
  private JFrame frame;
  private JPanel menuPanel;
  private JPanel contentPanel;

  private final AccountRepository accountRepository;
  private final String myAccountIdentifier;
  private final String otherAccountIdentifier;

  private final TransferService transferService;

  public static void main(String[] args) {
    MakaoBank application = new MakaoBank();
    application.run();
  }

  public MakaoBank() {
    accountRepository = new AccountRepository();
    myAccountIdentifier = "352-0528-2645-53";
    otherAccountIdentifier = "179-20-155318";

    transferService = new TransferService(accountRepository);
  }

  public void run() {
    initFrame();
    initMenuPanel();
    initContentPanel();

    frame.setVisible(true);
  }

  public void initFrame() {
    frame = new JFrame("Makao Bank");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 600);
    frame.setLocation(100, 70);
  }

  public void initMenuPanel() {
    menuPanel = new JPanel();

    menuPanel.add(createAmountButton());
    menuPanel.add(createTransferButton());
    menuPanel.add(createTransactionsButton());

    frame.add(menuPanel, BorderLayout.PAGE_START);
  }

  public void initContentPanel() {
    contentPanel = new JPanel();

    frame.add(contentPanel);
  }

  public JButton createAmountButton() {
    JButton amountButton = new JButton("잔액 조회");
    amountButton.addActionListener(event -> {
      JPanel amountPanel = new AmountPanel(
          accountRepository, myAccountIdentifier, otherAccountIdentifier
      );
      showContentPanel(amountPanel);
    });

    return amountButton;
  }

  public JButton createTransferButton() {
    JButton transferButton = new JButton("계좌 이체");
    transferButton.addActionListener(event -> {
      JPanel transferPanel = new TransferPanel(
          myAccountIdentifier, transferService
      );
      showContentPanel(transferPanel);
    });

    return transferButton;
  }

  public JButton createTransactionsButton() {
    JButton transactionsButton = new JButton("거래 내역");
    transactionsButton.addActionListener(event -> {
      JPanel transactionsPanel = new TransactionsPanel(
          accountRepository, myAccountIdentifier, otherAccountIdentifier
      );
      showContentPanel(transactionsPanel);
    });

    return transactionsButton;
  }

  public void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }
}
