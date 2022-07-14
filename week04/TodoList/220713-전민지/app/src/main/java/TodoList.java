import models.Task;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TodoList {
  private JFrame frame;
  private JPanel formPanel;
  private JPanel contentPanel;

  public static void main(String[] args) {
    TodoList application = new TodoList();
    application.run();
  }

  public void run() {
    // 가장 최소한의 레이아웃 준비
    frame = new JFrame("Todo List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 600);
    frame.setVisible(true);

    // 처리
    initContentPanel();

    initForm();

    // 출력

  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    frame.add(contentPanel);
    frame.setVisible(true);
  }

  public void initForm() {
    formPanel = new JPanel();
    frame.add(formPanel, BorderLayout.PAGE_START);

    JTextField textField = new JTextField(10);
    formPanel.add(textField);

    JButton addButton = new JButton("추가");
    addButton.addActionListener(event -> {
      String taskTitle = textField.getText();

      LocalDateTime localDateTime = LocalDateTime.now();
      String taskCreationTime = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);

      Task task = new Task(taskTitle, taskCreationTime);
      TasksPanel tasksPanel = new TasksPanel();
      showContentPanel(tasksPanel);
    });
    formPanel.add(addButton);
  }

  public void showContentPanel(TasksPanel tasksPanel) {
    contentPanel.removeAll();
    contentPanel.add(tasksPanel);

    tasksPanel.setVisible(false);
    tasksPanel.setVisible(true);

    frame.setVisible(true);
  }
}


// 1. csv 파일에 task를 추가해주어야 함

// 2. 추가한 taskRepository csv 파일을 기반으로 하여 List를 만들어 줌
// -> 주의. task의 state에 관계 없이 모든 리스트를 가져와서 list로 만들어주되,
// 리스트에서 자료를 뽑아올 떄 type이 deleted인 건 안 뽑아오고
// todo랑 done이 있는 상태에서 이 두개를 구분해서 폼을 다르게 구현...
//

// 3