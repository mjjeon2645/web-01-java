import javax.swing.*;
import java.awt.*;

public class HelloToYou {
  String name = "world";
  public static void main(String[] args) {
    HelloToYou application = new HelloToYou();
    application.run();

  }

  public void run() {
    JFrame frame = new JFrame("Hello to you");
    frame.setSize(400,500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setLayout(new GridLayout(3,1));

    JLabel label = new JLabel(greetingMessage());
    frame.add(label);

    JTextField textField = new JTextField(10);
    frame.add(textField);

    JButton button = new JButton("확인");
    frame.add(button);
    button.addActionListener(event -> {
      name = textField.getText();
      label.setText(greetingMessage());

    });

    frame.setVisible(true);
  }

  private String greetingMessage() {
    return "Hello, " + name + "!";
  }
}
