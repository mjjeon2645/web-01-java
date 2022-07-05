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
    frame.setSize(400, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    textField = new JTextField(10);
    frame.add(textField, BorderLayout.PAGE_START);
    textField.setEditable(false);
    textField.setHorizontalAlignment(JTextField.RIGHT);

    panel = new JPanel();
    frame.add(panel);
    panel.setLayout(new GridLayout(4, 3));

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
