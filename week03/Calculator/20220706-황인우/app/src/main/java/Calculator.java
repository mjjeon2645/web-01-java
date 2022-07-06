import javax.swing.*;
import java.awt.*;

public class Calculator {
  private long currentNumber = 0;
  private long accumulator = 0;
  private String currentOperator = "";

  private JTextField textField;

  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    JFrame frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(100, 75);

    textField = new JTextField();
    textField.setEditable(false);
    textField.setHorizontalAlignment(JTextField.RIGHT);
    showNumber(currentNumber);

    frame.add(textField, BorderLayout.PAGE_START);

    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(0, 3));

    for (int i = 1; i <= 10; i += 1) {
      int number = i % 10;

      JButton numberButton = new JButton(Integer.toString(number));
      numberButton.addActionListener(event -> {
        addNumberToCurrentNumber(number);
        showNumber(currentNumber);
      });

      buttonsPanel.add(numberButton);
    }

    String[] operators = {"+", "-", "*", "/", "="};
    for (String operator : operators) {
      JButton operatorButton = new JButton(operator);
      operatorButton.addActionListener(event -> {
        switch (currentOperator) {
          case "" -> accumulator = currentNumber;
          case "+" -> accumulator += currentNumber;
          case "-" -> accumulator -= currentNumber;
          case "*" -> accumulator *= currentNumber;
          case "/" -> accumulator /= currentNumber;
        }
        currentOperator = operator;
        currentNumber = 0;

        showNumber(accumulator);
      });

      buttonsPanel.add(operatorButton);
    }

    frame.add(buttonsPanel);

    frame.pack();
    frame.setVisible(true);
  }

  private void addNumberToCurrentNumber(int number) {
    currentNumber = (currentNumber * 10) + number;
  }

  private void showNumber(long number) {
    textField.setText(Long.toString(number));
  }
}
