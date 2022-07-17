package panels;

import models.Task;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InputPanel extends JPanel {
  private final List<Task> tasks;

  private TasksPanel tasksPanel;

  private JLabel label;
  private JTextField textField;
  private JButton addTaskButton;

  public InputPanel(List<Task> tasks, TasksPanel tasksPanel) {
    this.tasks = tasks;

    this.tasksPanel = tasksPanel;

    this.setBackground(Color.ORANGE);

    initLabel();
    initTextField();
    initAddTaskButton();
  }

  public void initLabel() {
    label = new JLabel("할 일: ");
    this.add(label);
  }

  public void initTextField() {
    textField = new JTextField(10);
    this.add(textField);
  }

  public void initAddTaskButton() {
    addTaskButton = new JButton("추가");
    addTaskButton.addActionListener(event -> {
      Task task = new Task(textField.getText());

      tasks.add(task);

      tasksPanel.updateTasksPanel();

      textField.setText("");
    });
    this.add(addTaskButton);
  }
}
