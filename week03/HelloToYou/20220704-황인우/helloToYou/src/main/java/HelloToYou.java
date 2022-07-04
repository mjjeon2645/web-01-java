import javax.swing.*;
import java.awt.*;

public class HelloToYou {
  public static void main(String[] args) {
    HelloToYou helloToYou = new HelloToYou();
    helloToYou.run();
  }

  public void run() {
    JFrame frame = new JFrame("Hello To You");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 150);

    frame.setLayout(new GridLayout(3, 1));

    JLabel label = new JLabel("Hello, world!");
    frame.add(label);

    JTextField textField = new JTextField(15);
    frame.add(textField);

    JButton button = new JButton("확인");
    button.addActionListener(event -> {
      String name = textField.getText();
      label.setText("Hello, " + name + "!");
    });
    frame.add(button);

    frame.setVisible(true);
  }
}
