import models.Task;
import repository.TasksRepository;

import javax.swing.*;
import java.awt.*;

public class TodoList {
  private JFrame frame;
  private JPanel mainPanel;
  private JPanel titlePanel;
  private JPanel contentPanel;
  private JTextField textField;
  private TasksRepository tasksRepository;

  public static void main(String[] args) {
    TodoList appliaction = new TodoList();
    appliaction.run();
  }

  private void run() {

    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(350, 500);

    initTitlePanel();
    initFormPanel();
    initContentPanel();

    frame.setVisible(true);
  }

  private void initTitlePanel() {
    tasksRepository = new TasksRepository();
    titlePanel = new JPanel();
    JLabel titleLabel = new JLabel("할 일 목록");
    titlePanel.add(titleLabel, BorderLayout.PAGE_START);
    frame.add(titlePanel, BorderLayout.PAGE_START);
    titlePanel.setBackground(Color.pink);
  }

  private void initFormPanel() {
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    initMenuPanel();
    frame.add(mainPanel);
  }

  private void initMenuPanel() {
    JPanel menuPanel = new JPanel();
    menuPanel.add(new JLabel("할 일"));

    textField = new JTextField(10);
    menuPanel.add(textField);

    menuPanel.add(createAddTodoButton());
    mainPanel.add(menuPanel, BorderLayout.PAGE_START);
  }

  private JButton createAddTodoButton() {
    JButton button = new JButton("추가");
    button.addActionListener(event -> {
      tasksRepository.addTask(textField.getText());
      TaskPanel taskPanel = new TaskPanel(tasksRepository, this);
      showContentPanel(taskPanel);
    });
    return button;
  }

  private void initContentPanel() {
    contentPanel = new JPanel();
    mainPanel.add(contentPanel);
  }

  public void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }
}
