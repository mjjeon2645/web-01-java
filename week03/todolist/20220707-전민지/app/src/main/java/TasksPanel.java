import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TasksPanel extends JPanel {
  TasksPanel(TaskRepository taskRepository) {

    this.setLayout(new GridLayout(taskRepository.tasksSize(), 1));

    for (String task : taskRepository.tasks()) {
      JPanel taskPanel = new JPanel();
      this.add(taskPanel);

      JCheckBox checkBox = new JCheckBox();
      taskPanel.add(checkBox);

      JLabel taskTitle = new JLabel(task);
      taskTitle.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
          if (checkBox.isSelected()) {
            checkBox.setSelected(false);
            return;
          }
          checkBox.setSelected(true);
        }
      });

      taskPanel.add(taskTitle);

      JButton deleteTaskButton = new JButton("X");
      deleteTaskButton.addActionListener(event -> {
        taskRepository.removeTask(task);
        this.remove(taskPanel);

        this.setVisible(false);
        this.setVisible(true);
      });

      taskPanel.add(deleteTaskButton);
    }
  }
}
