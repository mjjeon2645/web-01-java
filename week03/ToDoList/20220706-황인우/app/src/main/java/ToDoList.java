import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class ToDoList {
  private List<Task> tasks;

  private JFrame frame;
  private JPanel headerPanel;
  private JPanel contentPanel;

  public static void main(String[] args) {
    ToDoList application = new ToDoList();
    application.run();
  }

  public void run() {
    tasks = new ArrayList<>();

    createFrame();
    initHeaderPanel();
    initContentPanel();

    frame.setVisible(true);
  }

  public void createFrame() {
    frame = new JFrame("Todo List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 600);
    frame.setLocation(100, 70);
  }

  public void initHeaderPanel() {
    headerPanel = new JPanel();
    headerPanel.setLayout(new BorderLayout());

    initTitleLabel();
    initFormPanel();

    frame.add(headerPanel, BorderLayout.PAGE_START);
  }

  public void initTitleLabel() {
    JLabel titleLabel = new JLabel("할 일 목록");
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    headerPanel.add(titleLabel, BorderLayout.PAGE_START);
  }

  public void initFormPanel() {
    JPanel formPanel = new JPanel();

    formPanel.setLayout(new FlowLayout());

    JLabel spanLabel = new JLabel("할 일: ");
    formPanel.add(spanLabel);

    JTextField textField = new JTextField(10);
    formPanel.add(textField);

    JButton submitButton = new JButton("추가");
    submitButton.addActionListener(event -> {
      String task = textField.getText();
      tasks.add(new Task(task));
      textField.setText("");
      initToDoListPanel();
    });
    formPanel.add(submitButton);

    headerPanel.add(formPanel);
  }

  public void initToDoListPanel() {
    ToDoListPanel toDoListPanel = new ToDoListPanel(tasks, this);

    showToDoListPanel(toDoListPanel);
  }

  public void showToDoListPanel(ToDoListPanel toDoListPanel) {
    contentPanel.removeAll();
    toDoListPanel.initTaskPanels();
    contentPanel.add(toDoListPanel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }

  public void initContentPanel() {
    contentPanel = new JPanel();

    frame.add(contentPanel);
  }
}
