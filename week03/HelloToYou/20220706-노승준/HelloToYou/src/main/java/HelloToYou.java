import javax.swing.*;
import java.awt.*;

public class HelloToYou {
  private String name = "world";

  public static void main(String[] args) {
    HelloToYou application = new HelloToYou();
    application.run();
  }

  public void run() {
    JFrame frame = new JFrame("Hello to you");
    frame.setLayout(new GridLayout(3, 1));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);

    JLabel label = new JLabel(greetinMesage());
    frame.add(label);

    JTextField textField = new JTextField(10);
    frame.add(textField);

    JButton button = new JButton("확인");
    button.addActionListener(event -> {
      name = textField.getText();
      label.setText(greetinMesage());
    });
    frame.add(button);

    frame.setVisible(true);
  }

  public String greetinMesage() {
    return "Hello, " + name + "!";
  }
}
