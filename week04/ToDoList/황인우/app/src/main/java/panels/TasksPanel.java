package panels;

import application.ToDoList;
import models.Task;
import repositories.TaskRepository;

import javax.swing.*;
import java.awt.*;

public class TasksPanel extends JPanel {
  private ToDoList toDoListFrame;
  private JPanel contentPanel;
  private TaskRepository taskRepository;

  public TasksPanel(ToDoList toDoListFrame, JPanel contentPanel, TaskRepository taskRepository) {
    this.toDoListFrame = toDoListFrame;
    this.contentPanel = contentPanel;
    this.taskRepository = taskRepository;

    this.setBackground(Color.CYAN);
    updateTasksPanel();
  }

  public void updateTasksPanel() {
    this.removeAll();

    for (Task task : taskRepository.getTasks()) {
      String status = task.status();

      if (!status.equals(Task.DELETED)) {
        String text = task.text();
        boolean checked = status.equals(Task.DONE);

        JPanel taskPanel = new JPanel();
        JCheckBox statusCheckBox = new JCheckBox(text, checked);
        statusCheckBox.addActionListener(event -> {
          if (checked) {
            task.setStatusToDo();
          }
          if (!checked) {
            task.setStatusDone();
          }
          updateTasksPanel();
        });
        taskPanel.add(statusCheckBox);

        JButton deleteButton = new JButton("X");
        deleteButton.addActionListener(event -> {
          task.setStatusDeleted();
          updateTasksPanel();
        });
        taskPanel.add(deleteButton);

        this.add(taskPanel);
      }
    }

    toDoListFrame.showContentPanel(this);
  }
}
