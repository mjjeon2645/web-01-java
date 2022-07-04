// 숫자버튼 추가
// operator buttons add
// + clicked, currentNumber -> accumulator, currentNumber = 0
// clicked operator

// 1) 1, 3  currentNumber 13, , accumulator 0 , currentOperator ""
// 2)  +    currentNumber 0, accumulator 13, currentO +
// 3) 7    currentNum  7, accumulator 13, currentO +
// 4) =      currentNum 0 accumulator 13 + 7 = 20, currentO =
// 4-1)  +     currentNum 0 accumulator 13 + 7 = 20, currentO +

import org.checkerframework.checker.units.qual.C;

import javax.swing.*;
import java.awt.*;

public class Calculator {


  // GUI
  private JFrame frame;
  private JPanel panel;
  private JTextField textField;

  private CoreCalculator coreCalculator;

  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    coreCalculator = new CoreCalculator();

    frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    textField = new JTextField(10);
    textField.setEditable(false);
    updateDisplay(coreCalculator.getCurrentNumber());
    textField.setHorizontalAlignment(JTextField.RIGHT);
    frame.add(textField, BorderLayout.PAGE_START);

    // button add
    panel = new JPanel();
    panel.setLayout(new GridLayout(4, 3));
    frame.add(panel);

    initNumberButtons();
    initOperatorButtons();

    frame.pack();

    frame.setVisible(true);
  }

  public void initNumberButtons() {
    for (int i = 0; i < 10; i += 1) {
      int number = (i + 1) % 10;
      JButton button = new JButton(Integer.toString(number));
      button.addActionListener(event -> {
        coreCalculator.addNumbers(number);
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

  public void updateDisplay(long number) {
    textField.setText(Long.toString(number));
  }
}
