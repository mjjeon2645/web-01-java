import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TasksPanel extends JPanel {
  private final ToDoList couplerForContentPanel;

  private final TaskRepository taskRepository;

  public TasksPanel(ToDoList couplerForContentPanel,
                    TaskRepository taskRepository) {
    this.couplerForContentPanel = couplerForContentPanel;
    this.taskRepository = taskRepository;

    this.setBackground(Color.GREEN);
    this.setLayout(new GridLayout(0, 1));
  }

  public void createTaskPanels() {
    for (int i = 0; i < taskRepository.taskRepositorySize(); i += 1) {
      Task task = taskRepository.task(i);

      JPanel taskPanel = new JPanel();
      taskPanel.setBackground(Color.PINK);

      taskPanel.add(createCompletionStateCheckBox(task));
      taskPanel.add(createTaskLabel(task));
      taskPanel.add(createDeleteButton(task, i));

      this.add(taskPanel);
    }
  }

  public JCheckBox createCompletionStateCheckBox(Task task) {
    JCheckBox completionStateCheckBox = new JCheckBox(
        "", task.completed()
    );
    completionStateCheckBox.addActionListener(event -> {
      task.toggle();
    });

    return completionStateCheckBox;
  }

  private JLabel createTaskLabel(Task task) {
    JLabel taskLabel = new JLabel(task.task());
    taskLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        task.toggle();

        updateTasksPanel();
      }
    });

    return taskLabel;
  }

  public JButton createDeleteButton(Task task, int index) {
    JButton deleteButton = new JButton("X");
    deleteButton.addActionListener(event -> {
      taskRepository.delete(index);

      updateTasksPanel();
    });

    return deleteButton;
  }

  public void updateTasksPanel() {
    this.removeAll();

    this.createTaskPanels();

    couplerForContentPanel.showTasksPanel(this);
  }
}
