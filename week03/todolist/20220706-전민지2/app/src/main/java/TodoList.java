import javax.swing.*;
import java.awt.*;

public class TodoList {
  private JPanel taskListPanel;

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

    // taskList 패널 실현
    taskListPanel = new JPanel();
    taskListPanel.setBackground(Color.DARK_GRAY);
    contentPanel.add(taskListPanel);

    // 상단 form(라벨, 텍스트필드, 추가버튼) 세팅
    JPanel taskAddFormPanel = new JPanel();
    taskAddFormPanel.setBackground(Color.pink);
    contentPanel.add(taskAddFormPanel, BorderLayout.PAGE_START);

    JLabel subtitleLabel = new JLabel("할 일: ");
    taskAddFormPanel.add(subtitleLabel);

    JTextField textField = new JTextField(10);
    taskAddFormPanel.add(textField);

    JButton addButton = new JButton("추가");
    addButton.addActionListener(event -> {
      String text = textField.getText();

      // 1개의 Task에 대한 컴포넌트를 묶어줄 패널 세팅 및 컴포넌트 추가
      JPanel taskFormPanel = new JPanel();
      taskFormPanel.setBackground(Color.GREEN);
      taskListPanel.add(taskFormPanel);

      JCheckBox checkBox = new JCheckBox();
      taskFormPanel.add(checkBox);

      JLabel taskTitleLabel = new JLabel(text);
      taskFormPanel.add(taskTitleLabel);

      JButton deleteTaskButton = new JButton("X");
      taskFormPanel.add(deleteTaskButton);


      contentPanel.setVisible(false);
      contentPanel.setVisible(true);
      frame.setVisible(true);
    });
    taskAddFormPanel.add(addButton);

    // 하단 list 패널 세팅? 과연 필요할까?

  }
}
