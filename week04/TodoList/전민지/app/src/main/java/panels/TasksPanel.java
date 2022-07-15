package panels;

import application.TodoList;
import models.Task;
import models.Tasks;

import javax.swing.*;
import java.awt.*;

public class TasksPanel extends JPanel {
  private JPanel taskPanel;
  private Tasks tasks;
  private TodoList todoListFrame;

  public TasksPanel(Tasks tasks, TodoList todoList) {
    this.todoListFrame = todoList;
    this.tasks = tasks;
    this.setLayout(new GridLayout(0, 1));

    for (Task task : tasks.getTasks()) {
      initTask(task);
    }
  }

  public void updateTasksPanel(Tasks tasks) {
    this.removeAll();

    for (Task task : tasks.getTasks()) {
      initTask(task);
    }

    todoListFrame.showContentPanel(this);
  }

  public void initTask(Task task) {
    if (!task.state().equals("DELETED")) {
      createTaskPanel();

      createCheckBox(task);

      createTitleLabel(task);

      createDeleteButton(task);
    }
  }

  public void createTaskPanel() {
    taskPanel = new JPanel();
    this.add(taskPanel);
  }

  public void createCheckBox(Task task) {
    JCheckBox checkBox = new JCheckBox();

    if (task.state().equals("DONE")) {
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

  private void createDeleteButton(Task task) {
    JButton deleteButton = new JButton("X");
    deleteButton.addActionListener(event -> {
      task.deleted();
      updateTasksPanel(tasks);
    });
    taskPanel.add(deleteButton);
  }
}
