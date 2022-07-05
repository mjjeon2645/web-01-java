import javax.swing.*;
import java.awt.*;

//class -> 설명서, 어떤 프로그램을 짤건지, 어떤 프로그램인지 설명 ,명세
public class Calculator {
  private CoreCalculator coreCalculator;


  private JTextField textField;
  private JPanel panel;

  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    coreCalculator = new CoreCalculator();

    JFrame frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    textField = new JTextField(15);
    textField.setEditable(false);
    textField.setHorizontalAlignment(JTextField.RIGHT);
    updateDisplay(coreCalculator.getCurrentNumber());
    frame.add(textField, BorderLayout.PAGE_START);

    panel = new JPanel();
    panel.setLayout(new GridLayout(4, 3));
    frame.add(panel);

    initNumberButtons();
    initOperatorButtons();


    frame.pack();
    frame.setVisible(true);
  }

  public void initNumberButtons() {
    for (int i = 0; i < 10; i += 1) {
      long number = (i + 1) % 10;
      JButton button = new JButton(Long.toString(number));
      panel.add(button);
      button.addActionListener(event -> {
        coreCalculator.addNumber(number);
        updateDisplay(coreCalculator.getCurrentNumber());
      });
    }
  }

  public void initOperatorButtons() {
    for (String operator : CoreCalculator.OPERATORS) {
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
