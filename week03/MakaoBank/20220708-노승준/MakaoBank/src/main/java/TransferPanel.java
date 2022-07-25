import javax.swing.*;
import java.awt.*;

public class TransferPanel extends JPanel {
  private JTextField transferAccountNumberTextField;
  private JTextField transferAmountTextField;
  private JTextField depositAccountNumberTextField;
  private JTextField depositAmoutTextField;

  private JPanel transferPanel;
  private JPanel transferTitlePanel;
  private JPanel inputTransferAccounNumber;
  private JPanel inputTransferAmountPanel;
  private JPanel transferButtonPanel;

  private JPanel depositButtonPanel;
  private JPanel depositPanel;
  private JPanel depositTitlePanel;
  private JPanel inputDepositAccoutNumber;
  private JPanel inputDepositAmout;

  private Account account;

  TransferPanel(Account account) {
    this.account = account;
    this.setLayout(new GridLayout(2, 1));

    createTransferPanel();
    createTransferTitle();
    createInputTransferAccountNumber();
    createInputTransferAmount();
    createTransferButton(account);

    createDepositPanel();
    createDepositTitle();
    createInputDepositAccountNumber();
    createInputDepositAmount();
    createDepositButton(account);

  }

  private void createTransferPanel() {
    transferPanel = new JPanel();
    transferPanel.setLayout(new GridLayout(4, 1));
    this.add(transferPanel);
  }

  private void createTransferTitle() {
    transferTitlePanel = new JPanel();
    transferTitlePanel.add(new JLabel("내 계좌에서 송금하기"));
    transferPanel.add(transferTitlePanel);
  }

  private void createInputTransferAccountNumber() {
    inputTransferAccounNumber = new JPanel();
    inputTransferAccounNumber.add(new JLabel("계좌 번호: "));
    transferAccountNumberTextField = new JTextField(10);
    inputTransferAccounNumber.add(transferAccountNumberTextField);
    transferPanel.add(inputTransferAccounNumber);
  }

  private void createInputTransferAmount() {
    inputTransferAmountPanel = new JPanel();
    inputTransferAmountPanel.add(new JLabel("금액: "));
    transferAmountTextField = new JTextField(10);
    inputTransferAmountPanel.add(transferAmountTextField);
    transferPanel.add(inputTransferAmountPanel);
  }

  private void createTransferButton(Account account) {
    transferButtonPanel = new JPanel();
    JButton transferButton = new JButton("송금");
    transferButton.addActionListener(event -> {
      account.transfer(Long.parseLong(transferAmountTextField.getText())
          , transferAccountNumberTextField.getText());
    });
    transferButtonPanel.add(transferButton);
    transferPanel.add(transferButtonPanel);
  }

  private void createDepositTitle() {
    depositTitlePanel = new JPanel();
    depositTitlePanel.add(new JLabel("상대 계좌에서 입금하기"));
    depositPanel.add(depositTitlePanel);
  }

  private void createDepositPanel() {
    depositPanel = new JPanel();
    depositPanel.setLayout(new GridLayout(4, 1));
    this.add(depositPanel);
  }

  private void createInputDepositAccountNumber() {
    inputDepositAccoutNumber = new JPanel();
    inputDepositAccoutNumber.add(new JLabel("계좌 번호: "));
    depositAccountNumberTextField = new JTextField(10);
    inputDepositAccoutNumber.add(depositAccountNumberTextField);
    depositPanel.add(inputDepositAccoutNumber);
  }

  private void createInputDepositAmount() {
    inputDepositAmout = new JPanel();
    inputDepositAmout.add(new JLabel("금액: "));
    depositAmoutTextField = new JTextField(10);
    inputDepositAmout.add(depositAmoutTextField);
    depositPanel.add(inputDepositAmout);
  }

  private void createDepositButton(Account account) {
    depositButtonPanel = new JPanel();
    JButton depostButton = new JButton("입금");
    depostButton.addActionListener(event -> {
      account.deposit(Long.parseLong(depositAmoutTextField.getText())
          , depositAccountNumberTextField.getText());
    });
    depositButtonPanel.add(depostButton);
    depositPanel.add(depositButtonPanel);
  }
}
