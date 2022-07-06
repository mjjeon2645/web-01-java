import repository.TasksRepository;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TodoPanel extends JPanel {
  private final JCheckBox checkBox;
  private final JLabel taskLabel;
  private final JButton deleteButton;
  private final TasksRepository tasksRepository;

  TodoPanel(TasksRepository tasksRepository) {
    this.tasksRepository = tasksRepository;

    checkBox = new JCheckBox();
    this.add(checkBox);

    taskLabel = new JLabel(tasksRepository.task());
    this.add(taskLabel);

    taskLabel.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if(checkBox.isSelected()) {
          checkBox.setSelected(false);
          return;
        }
        checkBox.setSelected(true);
      }
    });

    deleteButton = new JButton("X");
    deleteButton.addActionListener(event -> {
      deleteTodo();
      // 몇번째를 삭제해라가 들어가야하나
    });
    this.add(deleteButton);
  }

  private void deleteTodo() {
    this.removeAll();
    this.setVisible(false);
    this.setVisible(true);
  }
}
