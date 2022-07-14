package panels;
import models.Task;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FormPanel extends JPanel {

  public FormPanel(List<Task> tasks, TasksPanel tasksPanel) {
    this.setLayout(new FlowLayout());

    JLabel label = new JLabel("할 일");
    this.add(label);

    JTextField textField = new JTextField(10);
    this.add(textField);

    JButton registerButton = new JButton("추가");
    registerButton.addActionListener(event -> {
      tasks.add(new Task(textField.getText()));
      tasksPanel.updateTasksPanel();
      textField.setText("");
    });
    this.add(registerButton);
  }
}
