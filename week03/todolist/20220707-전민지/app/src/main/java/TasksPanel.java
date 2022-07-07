import javax.swing.*;
import java.awt.*;

public class TasksPanel extends JPanel {
  TasksPanel(TaskRepository taskRepository) {

    this.setLayout(new GridLayout(taskRepository.tasksSize(), 1));

    for (String task : taskRepository.getTasks()) {
      JPanel taskPanel = new JPanel();
      this.add(taskPanel);

      JCheckBox checkBox = new JCheckBox();
      taskPanel.add(checkBox);

      JLabel taskTitle = new JLabel(task);
      taskPanel.add(taskTitle);

      JButton deleteTaskButton = new JButton("X");
      deleteTaskButton.addActionListener(event -> {
        this.remove(taskPanel);

        this.setVisible(false);
        this.setVisible(true);
      });
      taskPanel.add(deleteTaskButton);
    }
  }
}
