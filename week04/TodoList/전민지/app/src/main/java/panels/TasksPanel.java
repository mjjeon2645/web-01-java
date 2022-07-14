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
      initTaskPanel();

      initCheckBox(task);

      taskTitleLabel(task);

      initDeleteButton(task);
    }
  }

  public void initTaskPanel() {
    taskPanel = new JPanel();
    this.add(taskPanel);
  }

  public void initCheckBox(Task task) {
    JCheckBox checkBox = new JCheckBox();
    checkBox.addActionListener(event -> {
      //TODO. 액션 리스너 구현 필요 -> 체크박스는 on, state는 done으로 세팅
    });
    taskPanel.add(checkBox);
  }

  public void taskTitleLabel(Task task) {
    JLabel taskTitleLabel = new JLabel(task.taskTitle());
    taskPanel.add(taskTitleLabel);
  }

  private void initDeleteButton(Task task) {
    JButton deleteButton = new JButton("X");
    deleteButton.addActionListener(event -> {
      task.setStateDeleted();
      updateTasksPanel(tasks);
    });
    taskPanel.add(deleteButton);
  }
}
