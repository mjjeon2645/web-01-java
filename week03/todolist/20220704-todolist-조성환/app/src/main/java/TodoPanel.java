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

    taskLabel = new JLabel(this.tasksRepository.getTask());
    this.add(taskLabel);

    taskLabel.addMouseListener(new MouseAdapter() {
      public void mouseClicked (MouseEvent e){
        checkBox.setAction();
      }
    });


    deleteButton = new JButton("X");
    deleteButton.addActionListener(event -> {
      deleteTodo();
    });
    this.add(deleteButton);
  }

  private void deleteTodo() {
    this.remove(checkBox);
    this.remove(taskLabel);
    this.remove(deleteButton);
    this.setVisible(false);
    this.setVisible(true);
  }
}
