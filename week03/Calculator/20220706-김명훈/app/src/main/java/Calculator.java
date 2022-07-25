import org.checkerframework.checker.units.qual.*;

import javax.swing.*;
import java.awt.*;

public class Calculator {
  private JFrame frame;
  private JTextField textField;

  private CoreCalculator coreCalculator;


  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    coreCalculator = new CoreCalculator();

    frame = new JFrame("허접한 계산기");

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


     textField = new JTextField(10);
     textField.setEditable(false);
    updateDisplay(coreCalculator.getCurrentNumber());
    frame.add(textField, BorderLayout.PAGE_START);
    textField.setHorizontalAlignment(JTextField.RIGHT);

    //숫자판 넣을 패널 생성
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(4,3));
    frame.add(panel);

    //숫자판 넣기
    for(int i = 0; i < 10; i += 1) {
      long number = ( i + 1 ) % 10;
      JButton button = new JButton(Long.toString(number));
      button.addActionListener(event -> {
        coreCalculator.addNumber(number);
        updateDisplay(coreCalculator.getCurrentNumber());
      });
      panel.add(button);
    }


    for(String operator : coreCalculator.OPERATORS) {
      JButton button = new JButton(operator);
      button.addActionListener(event -> {
        coreCalculator.calculate();

        coreCalculator.updateOperator(operator);
        updateDisplay(coreCalculator.getAccumulator());
      });
      panel.add(button);
    }

    frame.pack();
    frame.setVisible(true);

  }



  public void updateDisplay(long number) {
    textField.setText(Long.toString(number));
  }




}
