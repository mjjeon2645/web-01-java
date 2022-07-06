import javax.swing.*;
import java.awt.*;

public class HelloToYou {
  private String name = "world";

  public static void main(String[] args) {
    HelloToYou application = new HelloToYou();
    application.run();
  }

  public void run() {
    JFrame frame = new JFrame("Hello To You");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setLocation(150, 150);

    frame.setLayout(new GridLayout(3, 1));

    JLabel label = new JLabel(greetingMessage());
    frame.add(label);

    JTextField textField = new JTextField(15);
    frame.add(textField);

    JButton button = new JButton("확인");
    button.addActionListener(event -> {
      name = textField.getText();
      label.setText(greetingMessage());
    });
    frame.add(button);

    frame.setVisible(true);
  }

  public String greetingMessage() {
    return "Hello, " + name + "!";
  }
}
