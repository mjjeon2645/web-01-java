package panels;

import models.Task;
import repositories.TaskRepository;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {
  private JPanel contentPanel;
  private TasksPanel tasksPanel;
  private TaskRepository taskRepository;

  public InputPanel(JPanel contentPanel, TasksPanel tasksPanel, TaskRepository taskRepository) {
    this.contentPanel = contentPanel;
    this.tasksPanel = tasksPanel;
    this.taskRepository = taskRepository;

    initInputPanel();
  }

  public void initInputPanel() {
    JPanel inputPanel = new JPanel();
    inputPanel.setBackground(Color.ORANGE);

    JLabel label = new JLabel("할 일: ");
    inputPanel.add(label);

    JTextField textField = new JTextField(10);
    inputPanel.add(textField);

    JButton addButton = new JButton("추가");
    addButton.addActionListener(event -> {
      Task task = new Task(textField.getText());
      taskRepository.addTask(task);
      tasksPanel.updateTasksPanel();
    });
    inputPanel.add(addButton);

    contentPanel.add(inputPanel, BorderLayout.PAGE_START);
  }
}
