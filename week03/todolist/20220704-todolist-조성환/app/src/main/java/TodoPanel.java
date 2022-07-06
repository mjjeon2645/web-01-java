import models.Task;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TodoPanel extends JPanel {
  private final JCheckBox checkBox;
  private final JLabel taskLabel;
  private final JButton deleteButton;
  private final Task task;

  TodoPanel(Task task) {
    this.task = task;
    this.setLayout(new GridLayout());

    checkBox = new JCheckBox();
    this.add(checkBox);

    taskLabel = new JLabel(task.task());
    this.add(taskLabel);

    clickTaskLabel();

    deleteButton = new JButton("X");
    deleteButton.addActionListener(event -> {
      deleteTodo();
    });
    this.add(deleteButton);
  }

  private void clickTaskLabel() {
    taskLabel.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if(checkBox.isSelected()) {
          checkBox.setSelected(false);
          return;
        }
        checkBox.setSelected(true);
      }
    });
  }

  private void deleteTodo() {
    this.removeAll();
    this.setVisible(false);
    this.setVisible(true);
  }
}
