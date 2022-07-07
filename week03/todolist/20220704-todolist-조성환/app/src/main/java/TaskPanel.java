import repository.TasksRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TaskPanel extends JPanel {
  private TodoList todolist;
  private TasksRepository tasksRepository;

  TaskPanel(TasksRepository tasksRepository, TodoList todoList) {
    this.tasksRepository = tasksRepository;
    this.todolist = todoList;

    this.setLayout(new GridLayout(tasksRepository.tasksSize(), 1));

    createTaskPanels();
  }

  private void createTaskPanels() {
    for (String task : tasksRepository.getTask()) {
      JPanel panel = new JPanel();
      this.add(panel);

      JCheckBox checkBox = new JCheckBox();
      panel.add(checkBox);
      //멤버변 포문 다돌고
      JLabel taskLabel = new JLabel(task);
      clickTaskLabel(checkBox , taskLabel);
      panel.add(taskLabel);

      JButton deleteButton = new JButton("X");
      deleteButton.addActionListener(event -> {
        tasksRepository.deleteTask(task);
        updateTaskPanel();
        todolist.showContentPanel(this);
      });
      panel.add(deleteButton);
    }
  }

  private void clickTaskLabel(JCheckBox checkBox, JLabel taskLabel) {
    taskLabel.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (checkBox.isSelected()) {
          checkBox.setSelected(false);
          return;
        }
        checkBox.setSelected(true);
      }
    });
  }

  private void updateTaskPanel() {
    this.removeAll();
    this.createTaskPanels();
    this.setVisible(false);
    this.setVisible(true);
  }
}
