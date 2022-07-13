package panels;

import models.Task;
import models.Tasks;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormPanel extends JPanel {
  private Task task;
  private JTextField textField;

  public FormPanel(Tasks tasks) {
    initSubtitleLabel();

    initTextField();

    initAddTaskButton(tasks);
  }

  public void initSubtitleLabel() {
    JLabel subTitleLabel = new JLabel("할 일: ");
    this.add(subTitleLabel);
  }

  public void initTextField() {
    textField = new JTextField(15);
    this.add(textField);
  }

  public void initAddTaskButton(Tasks tasks) {
    JButton addButton = new JButton("추가");
    addButton.addActionListener(event -> {
      String taskTitle = textField.getText();

      LocalDateTime localDateTime = LocalDateTime.now();
      String taskCreationTime = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);

      String state = task.STATETYPES[0];

      task = new Task(taskTitle, taskCreationTime, state);

      tasks.add(task);
    });

    this.add(addButton);
  }
}
