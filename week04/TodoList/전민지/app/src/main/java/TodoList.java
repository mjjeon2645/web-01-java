import models.Task;
import models.Tasks;
import utils.TaskWriter;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TodoList {
  private Task task;
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

      String state = task.STATETYPES[0];

      task = new Task(taskTitle, taskCreationTime, state);

      Tasks tasks = new Tasks();
      tasks.add(task);

      TasksPanel tasksPanel = new TasksPanel(tasks);
      showContentPanel(tasksPanel);
    });
    formPanel.add(addButton);
  }

  public void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);

    panel.setVisible(false);
    panel.setVisible(true);

    frame.setVisible(true);
  }
}
