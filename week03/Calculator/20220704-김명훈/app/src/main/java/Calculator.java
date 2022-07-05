import javax.swing.*;
import java.awt.*;

public class Calculator {
  private long currentNumber = 0;
  private long accumulator = 0;
  private String currentOperator = "";
  private static final String[] operators = new String[] {"+", "-", "*", "/", "="};

  private JTextField textField;
  private JFrame frame;
  private JPanel panel;




  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    frame = new JFrame("Calculator");

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    textField = new JTextField(Long.toString(currentNumber));
    frame.add(textField,BorderLayout.PAGE_START);
    textField.setHorizontalAlignment(JTextField.RIGHT);

    panel = new JPanel();
    panel.setLayout(new GridLayout(4,3));

    initMenuButtons();

    initOperatorButtons();

    frame.add(panel);
    frame.pack();

    frame.setVisible(true);

  }

  private void initMenuButtons() {
    for(int i = 0; i < 10; i += 1 ) {
      int number = (i + 1) % 10 ;
      JButton button = new JButton(Integer.toString(number));
      panel.add(button);

      button.addActionListener(event ->{
        addNumber(number);
        updateDisplay(currentNumber);
      });
    }
  }

  private void initOperatorButtons() {

    for(String operator : operators) {
      JButton button = new JButton(operator);
      panel.add(button);
      button.addActionListener(event -> {
        switch (currentOperator) {
          case "" -> accumulator = currentNumber;
          case "+" -> accumulator += currentNumber;
          case "-" -> accumulator -= currentNumber;
          case "*" -> accumulator *= currentNumber;
          case "/" -> accumulator /= currentNumber;
        }
        currentOperator = operator;
        currentNumber = 0;
        updateDisplay(accumulator);
      });
    }
  }

  private void addNumber(int number) {
    currentNumber *= 10;
    currentNumber += number;
  }

  public void updateDisplay(long number) {
    textField.setText(Long.toString(number));
  }
}
