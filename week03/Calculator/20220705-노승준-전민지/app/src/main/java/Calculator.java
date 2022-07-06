// 1. 1, 3 -> currentNumber 13, accumulator 0, currentOperator ""
// 2.  +  -> currentNumber 0, accumulator 13, currentOperator +
// 3. 7 -> currentNumber 7, accumulator 13, currentOperator +
// 4. = -> currentNumber 0 , accumulator 13 + 7 = 20, currentOperator =
// 4-1. + -> currentNumber 0, accumulator 13 + 7 = 20. currentOperator +

import javax.swing.*;
import java.awt.*;

public class Calculator {
  private CoreCalculator coreCalculator;

  private JFrame frame;
  private JTextField textField;
  private JPanel panel;

  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    coreCalculator = new CoreCalculator();

    frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);

    textField = new JTextField(10);
    updateDisplay(coreCalculator.getCurrentNumber());
    textField.setEditable(false);
    textField.setHorizontalAlignment(JTextField.RIGHT);
    frame.add(textField, BorderLayout.PAGE_START);

    panel = new JPanel();
    panel.setLayout(new GridLayout(4,3));
    frame.add(panel);

    initNumberButtons();
    initOperatorButtons();

    frame.pack();
    frame.setVisible(true);
  }

  public void updateDisplay(long number) {
    textField.setText(Long.toString(number));
  }

  public void initNumberButtons() {
    for(int i = 0; i < 10; i += 1) {
      int number = (i + 1) % 10;
      JButton button = new JButton(Integer.toString(number));
      button.addActionListener(event -> {
        coreCalculator.addNumber(number);
        updateDisplay(coreCalculator.getCurrentNumber());
      });
      panel.add(button);
    }
  }

  public void initOperatorButtons() {
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
}
