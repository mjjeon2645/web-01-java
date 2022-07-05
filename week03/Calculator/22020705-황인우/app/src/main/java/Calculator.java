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

    createFrame();
    initTextField();
    initButtonsPanel();
    showFrame();
  }

  public void createFrame() {
    frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(150, 150);
  }

  public void initTextField() {
    textField = new JTextField(15);
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
      JButton button = new JButton(Integer.toString(number));
      button.addActionListener(event -> {
        coreCalculator.addCurrentNumber(number);
        showNumber(coreCalculator.currentNumber());
      });
      buttonsPanel.add(button);
    }
  }

  public void initOperatorButtons() {
    for (String operator : CoreCalculator.OPERATORS) {
      JButton button = new JButton(operator);
      button.addActionListener(event -> {
        coreCalculator.calculate(operator);
        showNumber(coreCalculator.accumulator());
      });
      buttonsPanel.add(button);
    }
  }

  public void showNumber(long number) {
    textField.setText(Long.toString(number));
  }

  public void showFrame() {
    frame.pack();
    frame.setVisible(true);
  }
}
