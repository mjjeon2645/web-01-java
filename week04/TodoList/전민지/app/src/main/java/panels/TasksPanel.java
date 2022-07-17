package panels;

import models.Task;
import models.Tasks;

import javax.swing.*;
import java.awt.*;

public class TasksPanel extends JPanel {
  private Tasks tasks;
  private JPanel taskPanel;

  public TasksPanel(Tasks tasks) {
    this.tasks = tasks;
    this.setLayout(new GridLayout(0, 1));

    initTask(tasks);
  }

  public void refresh(Tasks tasks) {
    this.removeAll();

    initTask(tasks);

    this.setVisible(false);
    this.setVisible(true);
  }

  public void initTask(Tasks tasks) {
    for (Task task : tasks.tasks()) {
      if (task.state() != Task.DELETED) {
        createTaskPanel();

        createCheckBox(task);

        createTitleLabel(task);

        createDeleteButton(task);
      }
    }
  }

  public void createTaskPanel() {
    taskPanel = new JPanel();
    this.add(taskPanel);
  }

  public void createCheckBox(Task task) {
    JCheckBox checkBox = new JCheckBox();

    if (task.state() == Task.DONE) {
      checkBox.setSelected(true);
    }

    checkBox.addActionListener(event -> {
      if (checkBox.isSelected()) {
        task.done();
      }

      if (!checkBox.isSelected()) {
        task.processing();
      }
    });

    taskPanel.add(checkBox);
  }

  public void createTitleLabel(Task task) {
    JLabel taskTitleLabel = new JLabel(task.taskTitle());
    taskPanel.add(taskTitleLabel);
  }

  public void createDeleteButton(Task task) {
    JButton deleteButton = new JButton("X");
    deleteButton.addActionListener(event -> {
      task.deleted();
      refresh(tasks);
    });

    taskPanel.add(deleteButton);
  }
}
