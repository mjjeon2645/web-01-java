import javax.swing.*;
import java.awt.*;

public class Calculator {
  private CoreCalculator coreCalculator;

  private JFrame frame;
  private JTextField textField;
  private JPanel buttonsPanel;

  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    coreCalculator = new CoreCalculator();

    initFrame();
    initTextField();
    initButtonsPanel();

    frame.pack();
    frame.setVisible(true);
  }

  public void initFrame() {
    frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(100, 70);
  }

  public void initTextField() {
    textField = new JTextField(12);
    textField.setEditable(false);
    textField.setHorizontalAlignment(JTextField.RIGHT);
    showNumber(coreCalculator.currentNumber());

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
      int number = i % 10;

      JButton numberButton = new JButton(Integer.toString(number));
      numberButton.addActionListener(event -> {
        coreCalculator.addNumberToCurrentNumber(number);
        showNumber(coreCalculator.currentNumber());
      });

      buttonsPanel.add(numberButton);
    }
  }

  public void initOperatorButtons() {


    for (String operator : CoreCalculator.OPERATORS) {
      JButton operatorButton = new JButton(operator);
      operatorButton.addActionListener(event -> {
        coreCalculator.calculate();
        coreCalculator.setCurrentOperator(operator);
        showNumber(coreCalculator.accumulator());
      });

      buttonsPanel.add(operatorButton);
    }
  }

  public void showNumber(long number) {
    textField.setText(Long.toString(number));
  }
}
