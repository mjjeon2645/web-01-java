package panels;

import models.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TasksPanel extends JPanel {

  private List<Task> tasks;

  public TasksPanel(List<Task> tasks) {
    this.tasks = tasks;
    this.setLayout(new GridLayout(0, 1));

    addContentPanel();
  }

  public void addContentPanel() {
    for (Task task : tasks) {
      if(task.state().equals("DELETION")) {
        continue;
      }

      JPanel taskPanel = new JPanel();

      JCheckBox taskCheckBox = new JCheckBox();
      if (task.state().equals("COMPLETION")) {
        taskCheckBox.setSelected(true);
      }

      taskCheckBox.addActionListener(event -> {
        task.complete();
      });
      taskPanel.add(taskCheckBox);

      JLabel taskTitleLabel = new JLabel(task.toString());
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
        task.delete();

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
