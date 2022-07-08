import javax.swing.*;
import java.awt.*;

public class Calculator {
  private JTextField textField;
  private CoreCalculator coreCalculator;

  public static void main(String[] args){
    Calculator application = new Calculator();
    application.run();
  }

  private void run() {
    coreCalculator = new CoreCalculator();

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);

    textField = new JTextField(10);
    updateNumber(coreCalculator.getCurrentNumber());
    textField.setHorizontalAlignment(JTextField.RIGHT);
    textField.setEditable(false);
    frame.add(textField, BorderLayout.PAGE_START);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(4, 3));
    frame.add(panel);

    for(int i = 0; i<10; i+=1){
      int number = (i + 1) % 10;
      JButton button = new JButton(Integer.toString(number));
      button.addActionListener(event -> {
        coreCalculator.addNumber(number);
        updateNumber(coreCalculator.getCurrentNumber());
      });
      panel.add(button);
    }

    for(String operator : CoreCalculator.OPERATORS){
      JButton button = new JButton(operator);
      button.addActionListener(event -> {
        coreCalculator.calculate();
        coreCalculator.updateOperator(operator);
        updateNumber(coreCalculator.getAccumulator());
      });
      panel.add(button);
    }
    frame.setVisible(true);
  }


  private void updateNumber(long number) {
    textField.setText(Long.toString(number));
  }
}
