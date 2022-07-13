package panels;

import models.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TasksPanel extends JPanel {
  private final List<Task> tasks;
  private JPanel panel;

  public TasksPanel(List<Task> tasks) {
    this.tasks = tasks;

    this.setLayout(new GridLayout());

    createTasksList();
  }

  public void createTasksList() {
    for(Task task : tasks){
      panel = new JPanel();

      panel.add(createCheckBox(task));
      panel.add(createTaskLabel(task));
      panel.add(createDeleteButton(task));
      this.add(panel);
    }
  }

  public JCheckBox createCheckBox(Task task) {
    JCheckBox checkBox = new JCheckBox();

    checkBox.addActionListener(event -> {
      // 버튼을 누르면 식별자가 바뀌어야함 성공상태
    });
    return checkBox;
  }

  private JLabel createTaskLabel(Task task) {
    JLabel taskLabel = new JLabel(task.task());

    taskLabel.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent event){
        // 테스크의 식별자 값이 바뀌어야함  checkbox와 마찬가지
      }
    });
    return taskLabel;
  }

  private JButton createDeleteButton(Task task) {
    JButton deleteButton = new JButton("X");

    deleteButton.addActionListener(event -> {
        updateTasksPanel();
    });

    return deleteButton;
  }
  public void updateTasksPanel() {
    this.removeAll();
    this.createTasksList();
    this.setVisible(false);
    this.setVisible(true);
  }
}
