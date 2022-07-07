import javax.swing.*;
import java.awt.*;

public class ToDoList {
  private final TaskRepository taskRepository;

  private JFrame frame;
  private JPanel headerPanel;
  private JPanel contentPanel;

  public static void main(String[] args) {
    ToDoList application = new ToDoList();
    application.run();
  }

  public ToDoList() {
    this.taskRepository = new TaskRepository();
  }

  public void run() {
    initFrame();
    initHeaderPanel();
    initContentPanel();

    frame.setVisible(true);
  }

  public void initFrame() {
    frame = new JFrame("Todo List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 500);
    frame.setLocation(100, 70);
  }

  public void initHeaderPanel() {
    headerPanel = new JPanel();
    headerPanel.setLayout(new BorderLayout());
    headerPanel.setBackground(Color.YELLOW);

    headerPanel.add(createTitleLabel(), BorderLayout.PAGE_START);
    headerPanel.add(createFormPanel());

    frame.add(headerPanel, BorderLayout.PAGE_START);
  }

  public JLabel createTitleLabel() {
    JLabel titleLabel = new JLabel("할 일 목록");
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    return titleLabel;
  }

  public JPanel createFormPanel() {
    JPanel formPanel = new JPanel();
    formPanel.setBackground(Color.ORANGE);

    JLabel label = createLabel();
    formPanel.add(label);

    JTextField textField = createTextField();
    formPanel.add(textField);

    JButton addTaskButton = createAddTaskButton(textField);
    formPanel.add(addTaskButton);

    return formPanel;
  }

  public JLabel createLabel() {
    return new JLabel("할 일: ");
  }

  public JTextField createTextField() {
    return new JTextField(12);
  }

  public JButton createAddTaskButton(JTextField textField) {
    JButton button = new JButton("추가");
    button.addActionListener(event -> {
      String task = textField.getText();
      taskRepository.addNewTask(new Task(task));
      textField.setText("");

      TasksPanel tasksPanel = new TasksPanel(this, taskRepository);
      tasksPanel.createTaskPanels();
      showTasksPanel(tasksPanel);
    });

    return button;
  }

  public void showTasksPanel(TasksPanel tasksPanel) {
    contentPanel.removeAll();
    contentPanel.add(tasksPanel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    contentPanel.setBackground(Color.CYAN);

    frame.add(contentPanel);
  }
}
