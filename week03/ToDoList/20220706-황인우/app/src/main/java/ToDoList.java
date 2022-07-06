import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class ToDoList {
  private List<Task> tasks;

  private JFrame frame;
  private JPanel upperPanel;
  private JPanel lowerPanel;

  public static void main(String[] args) {
    ToDoList application = new ToDoList();
    application.run();
  }

  public void run() {
    tasks = new ArrayList<>();

    createFrame();
    initUpperPanel();
    initLowerPanel();

    frame.setVisible(true);
  }

  public void createFrame() {
    frame = new JFrame("Todo List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 600);
    frame.setLocation(100, 70);
  }

  public void initUpperPanel() {
    upperPanel = new JPanel();
    upperPanel.setLayout(new BorderLayout());

    initTitleLabel();
    initFormPanel();

    frame.add(upperPanel, BorderLayout.PAGE_START);
  }

  public void initTitleLabel() {
    JLabel titleLabel = new JLabel("할 일 목록");
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    upperPanel.add(titleLabel, BorderLayout.PAGE_START);
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
      tasks.add(new Task(textField.getText()));
      textField.setText("");
      initToDoListPanel();
    });
    formPanel.add(submitButton);

    upperPanel.add(formPanel);
  }

  public void initToDoListPanel() {
    ToDoListPanel toDoListPanel = new ToDoListPanel(tasks, this);

    addAndSetVisibleAboutToDoListPanel(toDoListPanel);
  }

  public void addAndSetVisibleAboutToDoListPanel(ToDoListPanel toDoListPanel) {
    lowerPanel.removeAll();
    toDoListPanel.initTaskPanels();
    lowerPanel.add(toDoListPanel);
    lowerPanel.setVisible(false);
    lowerPanel.setVisible(true);
  }

  public void initLowerPanel() {
    lowerPanel = new JPanel();

    frame.add(lowerPanel);
  }
}
