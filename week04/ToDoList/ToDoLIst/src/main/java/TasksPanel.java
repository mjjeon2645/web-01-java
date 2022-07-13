import models.Task;
import repositories.TaskRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TasksPanel extends JPanel {
  private TaskRepository taskRepository;
  private Task task;

  public TasksPanel(Task task, TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
    this.task = task;
    this.setLayout(new GridLayout(0,1));

    addContentPanel();
  }

  public void addContentPanel() {
    for (Task taskTitle : taskRepository.tasks()) {
      JPanel taskPanel = new JPanel();

      JCheckBox taskCheckBox = new JCheckBox();
      taskCheckBox.addActionListener(event -> {

      });
      taskPanel.add(taskCheckBox);

      JLabel taskTitleLabel = new JLabel(taskTitle.toString());
      taskTitleLabel.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
          if (taskCheckBox.isSelected()) {
            taskCheckBox.setSelected(false);
            return;
          }
          taskCheckBox.setSelected(true);
        }
      });
      taskPanel.add(taskTitleLabel);

      JButton taskDeleteButton = new JButton("X");
      taskDeleteButton.addActionListener(event -> {
        taskRepository.delete(taskTitle);

        refreshTaskPanel();
      });
      taskPanel.add(taskDeleteButton);

      this.add(taskPanel);
    }
  }

  private void refreshTaskPanel() {
    this.removeAll();
    this.addContentPanel();
    this.setVisible(false);
    this.setVisible(true);
  }
}
