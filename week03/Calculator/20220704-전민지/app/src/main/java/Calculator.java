// 사용자 시나리오
// 1) 1 누르고 3 = currentNumber = 13, accumulator = 0, currentOperator = ""
// 2) + 누르기 = currentNumber = 0, accumulator = 13, currentOperator = "+"
// 3) 7 누르기 = currentNumber = 7, accumulator 13, currentOperator = "+"
// 4) "=" 누르기 = currentNumber =0 accumulator 13 + 7, currentOperator = "="
// 4) "+" 누르기 = currentNumber = 0, accumulator = 20, currentOperator "+"

import org.checkerframework.checker.units.qual.C;

import javax.swing.*;
import java.awt.*;

public class Calculator {

  private JPanel panel;
  private JTextField textField;
  private CoreCalculator coreCalculator;

  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    coreCalculator = new CoreCalculator();

    JFrame frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 600);

    textField = new JTextField(10);
    updateDisplay(coreCalculator.getCurrentNumber());
    textField.setEditable(false);
    textField.setHorizontalAlignment(JTextField.RIGHT);
    frame.add(textField, BorderLayout.PAGE_START);

    panel = new JPanel();
    panel.setLayout(new GridLayout(4, 3));
    frame.add(panel);

    initNumberButton();
    initOperatorButton();

    frame.pack();
    frame.setVisible(true);
  }

  public void initNumberButton() {
    for (int i = 0; i < 10; i += 1) {
      int number = (i + 1) % 10;
      JButton button = new JButton(Integer.toString(number));
      button.addActionListener(event -> {
        coreCalculator.addNumber(number);
        updateDisplay(coreCalculator.getCurrentNumber());
      });
      panel.add(button);
    }
  }

  public void initOperatorButton() {
    for (String operator : coreCalculator.OPERATORS) {
      JButton button = new JButton(operator);
      button.addActionListener(event -> {
        coreCalculator.calculate();
        coreCalculator.updateOperator(operator);
        updateDisplay(coreCalculator.getAccumulator());
      });
      panel.add(button);
    }
  }

  public void updateDisplay(long number) {
    textField.setText(Long.toString(number));
  }
}
