package panels;

import models.Task;
import models.Tasks;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormPanel extends JPanel {
  private Task task;
  private JTextField textField;
  private TasksPanel tasksPanel;

  public FormPanel(Tasks tasks, TasksPanel tasksPanel) {
    this.tasksPanel = tasksPanel;

    createSubtitleLabel();

    createTextField();

    createAddTaskButton(tasks);
  }

  public void createSubtitleLabel() {
    JLabel subTitleLabel = new JLabel("할 일: ");
    this.add(subTitleLabel);
  }

  public void createTextField() {
    textField = new JTextField(15);
    this.add(textField);
  }

  public void createAddTaskButton(Tasks tasks) {
    JButton addButton = new JButton("추가");
    addButton.addActionListener(event -> {
      String taskTitle = textField.getText();

      textField.setText("");

      task = new Task(taskTitle);

      tasks.add(task);

      tasksPanel.updateTasksPanel(tasks);
    });

    this.add(addButton);
  }
}
