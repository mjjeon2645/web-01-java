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

  private void run() {
    coreCalculator = new CoreCalculator();

    frame = new JFrame("Calculator");
    frame.setSize(300, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    textField = new JTextField("0");
    textField.setHorizontalAlignment(JTextField.RIGHT);
    textField.setEditable(false);
    frame.add(textField, BorderLayout.PAGE_START);

    panel = new JPanel();
    panel.setLayout(new GridLayout(4,3));
    frame.add(panel);

    for(int i = 0; i < 10; i += 1) {
      int number = (i + 1) % 10;
      JButton button = new JButton(Integer.toString(number));
      button.addActionListener(event -> {
        coreCalculator.addNumber(number);
        updateDisplay(coreCalculator.getCurrentNumber());
      });
      panel.add(button);
    }

    for (String operator : CoreCalculator.OPERATORS) {
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

  public void updateDisplay(Long number) {
    textField.setText(Long.toString(number));
  }
}
