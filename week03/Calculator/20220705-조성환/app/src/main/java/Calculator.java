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

    textField = new JTextField();
    textField.setHorizontalAlignment(SwingConstants.RIGHT);
    textField.setEditable(false);
    frame.add(textField, BorderLayout.PAGE_START);

    panel = new JPanel();
    panel.setLayout(new GridLayout(4, 3));
    frame.add(panel);

    initNumberButton();
    initOperatorButton();

    frame.pack();
    frame.setVisible(true);
  }

  public void initNumberButton() {
    for(int i = 0; i<10; i+=1){
      int number = (i + 1) % 10;
      JButton button = new JButton(Integer.toString(number));
      button.addActionListener(event -> {
        coreCalculator.addNumber(number);
        updateDisplay(coreCalculator.getCurrentNumber());
      });
      panel.add(button);
    }
  }

  public void initOperatorButton() {
    for(String operator : coreCalculator.OPERATORS){
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
