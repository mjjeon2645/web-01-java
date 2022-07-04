//Use cases
//12 >> accumulator: 0,  currentNumber: 12, currentOperator: ""
//+  >> accumulator: 12, currentNumber: 0,  currentOperator: "+"
//3  >> accumulator: 12, currentNumber: 3,  currentOperator: "+"
//=  >> accumulator: 15, currentNumber: 0,  currentOperator: "="
//               (12 + 3)
//-  >> accumulator: 15, currentNumber: 0,  currentOperator: "-"
//10 >> accumulator: 15, currentNumber: 10, currentOperator: "-"
//*  >> accumulator: 5,  currentNumber: 0,  currentOperator: "*"
//3  >> accumulator: 5,  currentNumber: 3,  currentOperator: "*"
//=  >> accumulator: 15, currentNumber: 0,  currentOperator: "="
//               (5 * 3)

import javax.swing.*;
import java.awt.*;

public class Calculator {
  private JFrame frame;
  private JTextField textField;
  private JPanel buttonsPanel;

  private CoreCalculator coreCalculator;

  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    coreCalculator = new CoreCalculator();

    frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(150, 150);

    initTextField();
    initButtonsPanel();

    frame.pack();
    frame.setVisible(true);
  }

  public void initTextField() {
    textField = new JTextField("0");
    textField.setHorizontalAlignment(JTextField.RIGHT);
    textField.setEditable(false);
    frame.add(textField, BorderLayout.PAGE_START);
  }

  public void initButtonsPanel() {
    buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(0, 3));

    initNumberButtons();
    initOperatorButtons();

    frame.add(buttonsPanel);
  }

  public void initNumberButtons() {
    for (int i = 1; i <= 10; i += 1) {
      long number = i % 10;
      JButton button = new JButton(Long.toString(number));

      button.addActionListener(event -> {
        coreCalculator.setCurrentNumber(number);
        setText(coreCalculator.currentNumber());
      });

      buttonsPanel.add(button);
    }
  }

  public void initOperatorButtons() {
    for (String operator : CoreCalculator.OPERATORS) {
      JButton button = new JButton(operator);

      button.addActionListener(event -> {
        coreCalculator.setAccumulator();
        coreCalculator.setCurrentOperator(operator);
        coreCalculator.setCurrentNumberZero();
        setText(coreCalculator.accumulator());
      });

      buttonsPanel.add(button);
    }
  }

  public void setText(long number) {
    textField.setText(Long.toString(number));
  }
}
