import javax.swing.*;
import java.awt.*;

public class Calculator {
  private CoreCalculator coreCalculator;

  private JFrame frame;
  private JPanel panel;
  private JTextField textField;

  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    coreCalculator = new CoreCalculator();

    frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    textField = new JTextField(10);
    updateDisplay(coreCalculator.getCurrentNumber());
    textField.setHorizontalAlignment(JTextField.RIGHT);
    textField.setEditable(false);
    frame.add(textField, BorderLayout.PAGE_START);

    panel = new JPanel();
    panel.setLayout(new GridLayout(4, 3));
    frame.add(panel);

    initNumberButtons();
    initOperatorButtons();

    frame.pack();
    frame.setVisible(true);
  }

  private void initOperatorButtons() {
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

  private void initNumberButtons() {
    for (int i = 0; i < 10; i += 1) {
      long number = (i + 1) % 10;
      JButton button = new JButton(Long.toString(number));
      button.addActionListener(event -> {
        coreCalculator.addNumber(number);
        updateDisplay(coreCalculator.getCurrentNumber());
      });
      panel.add(button);
    }
  }

  public void updateDisplay(long number) {
    textField.setText(Long.toString(number));
  }
}
