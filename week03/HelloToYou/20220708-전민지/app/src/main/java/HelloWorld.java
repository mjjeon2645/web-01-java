import javax.swing.*;

public class HelloWorld {
  public static void main(String[] args) {
    HelloWorld application = new HelloWorld();
    application.run();
  }

  public void run() {
    JFrame frame = new JFrame("HelloWorld");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);

    JLabel label = new JLabel("Hello, world!");
    frame.add(label);

    frame.setVisible(true);
  }
}
