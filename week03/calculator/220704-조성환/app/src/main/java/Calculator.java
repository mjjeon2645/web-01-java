import javax.swing.*;
import java.awt.*;

// 사용자 시나리오
// 1, 3 입력 currentnumber =13 acculator = 0 operator = ""
// + 입력    currentnumber = 0;acculator = 13 operator = "+"
// 7입력     currentnumber = 7 acculator = 13 + 7 operator = "";
// =누름     currentnumber = 0; acculator = 20 operator = "=;


public class Calculator {
  private static final String[] OPERATORS = new String[]{"+", "-", "/", "*", "="};

  private JTextField textField;
  private JPanel panel;
  private CoreCalculator coreCalculator;

  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
     coreCalculator = new CoreCalculator();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);

    textField = new JTextField();
    textField.setEditable(false);
    textField.setHorizontalAlignment(SwingConstants.RIGHT);
    frame.add(textField, BorderLayout.PAGE_START);


    panel = new JPanel();
    panel.setLayout(new GridLayout(4, 3));
    frame.add(panel);

    initNumberButtons();
    initOperatorButton();


    frame.setVisible(true);
  }

  public void initNumberButtons() {
    for (int i = 0; i < 10; i += 1) {
      String number = Integer.toString((i + 1) % 10);
      JButton button = new JButton(number);
      button.addActionListener(event -> {
        coreCalculator.addNumber(number);
        updateDisplay(coreCalculator.getCurrentNumber());
      });
      panel.add(button);


    }
  }

  public void initOperatorButton() {
    for (String operator : OPERATORS) {
      JButton button = new JButton(operator);
      button.addActionListener(event -> {
        coreCalculator.calculate();
        coreCalculator.updateOperator(operator);
        updateDisplay(coreCalculator.getAccumulator());
      });


      panel.add(button);
    }
  }

  public void updateDisplay(String number) {
    textField.setText((number));
  }

}