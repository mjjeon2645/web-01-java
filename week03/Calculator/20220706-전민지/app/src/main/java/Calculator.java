import javax.swing.*;
import java.awt.*;

public class Calculator {
  private CoreCalculator coreCalculator;

  private JFrame frame;
  private JTextField textField;

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

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(4, 3));
    frame.add(panel);

    for (int i = 0; i < 10; i += 1) {
      long number = (i + 1) % 10;
      JButton button = new JButton(Long.toString(number));
      button.addActionListener(event -> {
        coreCalculator.addNumber(number);
        updateDisplay(coreCalculator.getCurrentNumber());
      });
      panel.add(button);
    }

    for (String operator : coreCalculator.OPERATORS) {
      JButton button = new JButton(operator);
      button.addActionListener(event -> {
        coreCalculator.calculate();
        coreCalculator.updateOperator(operator);
        updateDisplay(coreCalculator.getAccumulator());
      });
      panel.add(button);
    }

    frame.pack();
    frame.setVisible(true);
  }

  public void updateDisplay(long number) {
    textField.setText(Long.toString(number));
  }
}
