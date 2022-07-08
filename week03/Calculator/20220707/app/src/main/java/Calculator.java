import javax.swing.*;
import java.awt.*;

public class Calculator {
  private CoreCalculate coreCalculate = new CoreCalculate();


  private JTextField textField;

  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    JFrame frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    textField = new JTextField(Long.toString(coreCalculate.getCurrentNumber()));
    frame.add(textField,BorderLayout.PAGE_START);
    textField.setEditable(false);
    textField.setHorizontalAlignment(textField.RIGHT);

    JPanel panel = new JPanel();
    frame.add(panel);
    panel.setLayout(new GridLayout(4,3));

    for(int i = 0; i < 10 ; i += 1) {
      long number = (i + 1) % 10;
      JButton button = new JButton(Long.toString(number));
      panel.add(button);
      button.addActionListener(event -> {
        coreCalculate.addNumber(number);

        updateDisplay(coreCalculate.getCurrentNumber());
      });
    }


    for(String operator : coreCalculate.OPERATORS) {
      JButton button = new JButton(operator);
      panel.add(button);

        button.addActionListener(event -> {

        coreCalculate.coreCalculate(operator);
        updateDisplay(coreCalculate.getAccumulator());
      });
    }

    frame.pack();
    frame.setVisible(true);
  }




  private void updateDisplay(long number) {
    textField.setText(Long.toString(number));
  }
}
