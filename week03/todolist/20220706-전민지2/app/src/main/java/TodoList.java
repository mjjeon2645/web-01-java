import javax.swing.*;
import java.awt.*;

public class TodoList {
  public static void main(String[] args) {
    TodoList application = new TodoList();
    application.run();
  }

  public void run() {
    // frame 세팅
    JFrame frame = new JFrame("Todo List");
    frame.setBackground(Color.cyan);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 600);
    frame.setVisible(true);

    // 타이틀 라벨 세팅
    JLabel titleLabel = new JLabel("할 일 목록");
    titleLabel.setHorizontalAlignment(JTextField.CENTER);
    frame.add(titleLabel, BorderLayout.PAGE_START);

    // 컨텐트 패널 세팅
    JPanel contentPanel = new JPanel();
    contentPanel.setLayout(new BorderLayout());
    contentPanel.setBackground(Color.yellow);
    frame.add(contentPanel);

    // 상단 form(라벨, 텍스트필드, 추가버튼) 세팅
    JPanel formPanel = new JPanel();
    formPanel.setBackground(Color.pink);
    contentPanel.add(formPanel, BorderLayout.PAGE_START);

    JLabel subtitleLabel = new JLabel("할 일: ");
    formPanel.add(subtitleLabel);

    JTextField textField = new JTextField(10);
    formPanel.add(textField);

    JButton addButton = new JButton("추가");
    addButton.addActionListener(event -> {

    });
    formPanel.add(addButton);
  }
}
