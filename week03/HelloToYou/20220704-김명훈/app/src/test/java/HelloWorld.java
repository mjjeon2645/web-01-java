import javax.swing.*;
import java.awt.*;

public class HelloWorld {
  private JFrame frame;
  private String name = "world";

  public static void main(String[] args) {
    HelloWorld application = new HelloWorld();
    application.run();
  }

  public void run() {
    frame = new JFrame("Hello To You");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setSize(400,300);
    frame.setLayout(new GridLayout(3,1));


    String name = "world";
    JLabel label = new JLabel(greetingMessage());
    frame.add(label);

    JTextField textField = new JTextField(10);
    frame.add(textField);

    JButton button = new JButton("확인");
    frame.add(button);
    button.addActionListener(event -> {
      label.setText(textField.getText());
      label.setText(greetingMessage());

    });

    frame.setVisible(true);



  }


  private String greetingMessage() {
    return "Hello, " + name + "!";
  }
}
