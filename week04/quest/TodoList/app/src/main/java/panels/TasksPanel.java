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
  private JCheckBox checkBox;

  public TasksPanel(List<Task> tasks) {
    this.tasks = tasks;

    this.setLayout(new GridLayout(tasks.size(), 1));

    createTasksList();
  }

  public void createTasksList() {
    for (Task task : tasks) {
      if (!task.state().equals(Task.DELETE)) {
        panel = new JPanel();

        panel.add(createCheckBox(task));
        panel.add(createTaskLabel(task));
        panel.add(createDeleteButton(task));
        this.add(panel);
      }
    }
  }

  public JCheckBox createCheckBox(Task task) {
    String state = task.state();
    boolean checked = state.equals(Task.COMPLETE);

    checkBox = new JCheckBox("", checked);
    checkBox.addActionListener(event -> {
      if(!checked){
        task.setComplete();
      }
      if(checked){
        task.setProgress();
      }
    });
    return checkBox;
  }

  private JLabel createTaskLabel(Task task) {
    JLabel taskLabel = new JLabel(task.task());

    taskLabel.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent event) {
        task.setComplete();
        if (checkBox.isSelected()) {
          checkBox.setSelected(false);
          return;
        }
        checkBox.setSelected(true);
      }
    });
    return taskLabel;
  }

  private JButton createDeleteButton(Task task) {
    JButton deleteButton = new JButton("X");

    deleteButton.addActionListener(event -> {
      task.setDelete();
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
