import javax.swing.*;
import java.awt.*;

public class Calculator {
  private JTextField textField;
  private JPanel panel;
  private CoreCalculator coreCalculator;

  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  private void run() {
    coreCalculator = new CoreCalculator();

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);

    textField = new JTextField(10);
    textField.setHorizontalAlignment(JTextField.RIGHT);
    textField.setEditable(false);
    textField.setText(String.valueOf(coreCalculator.getCurrentNumber()));
    frame.add(textField, BorderLayout.PAGE_START);

    panel = new JPanel();
    panel.setLayout(new GridLayout(4, 3));
    frame.add(panel);
    
    for (int i = 0; i < 10; i += 1) {
      int number = (i + 1) % 10;
      JButton button = new JButton(Integer.toString(number));
      button.addActionListener(event -> {
        coreCalculator.addNumber(number);
        displayNumber(coreCalculator.getCurrentNumber());
      });
      panel.add(button);
    }

    

    for(String operator : CoreCalculator.OPERATORS){
      JButton button = new JButton(operator);
      button.addActionListener(event -> {
        coreCalculator.calculate();
        coreCalculator.updateOperator(operator);
        displayNumber(coreCalculator.getAccumulator());
      });
      panel.add(button);
    }


    frame.setVisible(true);
  }

  private void displayNumber(long number) {
    textField.setText(Long.toString(number));
  }
}
