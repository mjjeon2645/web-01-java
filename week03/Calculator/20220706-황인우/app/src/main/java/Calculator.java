import javax.swing.*;
import java.awt.*;

public class Calculator {
  private long currentNumber;

  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    JFrame frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(100, 75);

    JTextField textField = new JTextField();
    textField.setEditable(false);
    textField.setHorizontalAlignment(JTextField.RIGHT);
    textField.setText(Long.toString(currentNumber));

    frame.add(textField, BorderLayout.PAGE_START);

    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(0, 3));

    for (int i = 1; i <= 10; i += 1) {
      int number = i % 10;

      JButton numberButton = new JButton(Integer.toString(number));
      numberButton.addActionListener(event -> {
        currentNumber = (currentNumber * 10) + number;

        textField.setText(Long.toString(currentNumber));
      });

      buttonsPanel.add(numberButton);
    }

    String[] operators = {"+", "-", "*", "/", "="};
    for (String operator : operators) {
      JButton operatorButton = new JButton(operator);
      numberButton.addActionListener(event -> {
        currentNumber = (currentNumber * 10) + number;

        textField.setText(Long.toString(currentNumber));
      });

      buttonsPanel.add(numberButton);
    }

    frame.add(buttonsPanel);

    frame.pack();
    frame.setVisible(true);
  }
}
