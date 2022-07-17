package panels;

import models.Task;

import javax.swing.*;
import java.util.List;
import java.awt.*;

public class TasksPanel extends JPanel {
  private final List<Task> tasks;

  private JPanel contentPanel;

  public TasksPanel(List<Task> tasks, JPanel contentPanel) {
    this.tasks = tasks;

    this.contentPanel = contentPanel;

    this.setBackground(Color.CYAN);

    updateTasksPanel();
  }

  public void updateTasksPanel() {
    this.removeAll();

    for (Task task : tasks) {
      if (!task.status().equals(Task.DELETED)) {
        JPanel taskPanel = createTaskPanel(task);

        this.add(taskPanel);
      }
    }

    showContentPanel(this);
  }

  public JPanel createTaskPanel(Task task) {
    JPanel taskPanel = new JPanel();

    JCheckBox statusCheckBox = createStatusCheckBox(task);
    taskPanel.add(statusCheckBox);

    JButton deleteButton = createDeleteButton(task);
    taskPanel.add(deleteButton);

    return taskPanel;
  }

  public JCheckBox createStatusCheckBox(Task task) {
    String text = task.text();
    boolean checked = task.status().equals(Task.DONE);

    JCheckBox statusCheckBox = new JCheckBox(text, checked);

    statusCheckBox.addActionListener(event -> {
      if (checked) {
        task.processing();
      }
      if (!checked) {
        task.done();
      }

      updateTasksPanel();
    });

    return statusCheckBox;
  }

  public JButton createDeleteButton(Task task) {
    JButton deleteButton = new JButton("X");

    deleteButton.addActionListener(event -> {
      task.delete();

      updateTasksPanel();
    });

    return deleteButton;
  }

  public void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }
}
