
import javax.swing.*;
import java.awt.*;

public class HelloToYou {
  private String name = "World";

  public static void main(String[] args){
    HelloToYou HelloToyou = new HelloToYou();
    HelloToyou.run();
  }

  private void run() {
    JFrame frame = new JFrame(greetingMessage());
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setLayout(new GridLayout(3, 1));
    // Hello, world를 frame에 추가
    JLabel label = new JLabel(greetingMessage());
    frame.add(label);
    // 입력창 추가
    JTextField textField = new JTextField(10);
    frame.add(textField);

    //버튼 추가
    JButton button = new JButton("확인");
    // 버튼을 클릭 할 떄 이벤트 발생
    button.addActionListener(event -> {
      name = textField.getText();
      label.setText(greetingMessage());

    });
    frame.add(button);



    frame.setVisible(true);
  }

  private String greetingMessage() {
    return "Hello, " + name;
  }
}