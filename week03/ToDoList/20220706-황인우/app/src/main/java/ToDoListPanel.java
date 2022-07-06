import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ToDoListPanel extends JPanel {
  private final List<Task> tasks;

  private final ToDoList main;

  public ToDoListPanel(List<Task> tasks, ToDoList main) {
    this.tasks = tasks;
    this.main = main;

    this.setLayout(new GridLayout(tasks.size(), 1));
  }

  public void initTaskPanels() {
    for (Task task : tasks) {
      if (!task.deleted()) {
        JPanel taskPanel = new JPanel();

        taskPanel.add(createCompletionStateCheckBox(task));
        taskPanel.add(createTaskLabel(task));
        taskPanel.add(createDeletionButton(task));

        this.add(taskPanel);
      }
    }
  }

  public JCheckBox createCompletionStateCheckBox(Task task) {
    JCheckBox completionStateCheckBox = new JCheckBox("", task.completed());

    completionStateCheckBox.addActionListener(event -> {
      task.toggle();
      reinitTaskPanels();
    });

    return completionStateCheckBox;
  }

  public JLabel createTaskLabel(Task task) {
    JLabel taskLabel = new JLabel(task.task());

    taskLabel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        task.toggle();
        reinitTaskPanels();
      }
    });

    return taskLabel;
  }

  public JButton createDeletionButton(Task task) {
    JButton deletionButton = new JButton("X");

    deletionButton.addActionListener(event -> {
      task.delete();
      reinitTaskPanels();
    });

    return deletionButton;
  }

  public void reinitTaskPanels() {
    this.removeAll();

    main.addAndSetVisibleAboutToDoListPanel(this);
  }
}
