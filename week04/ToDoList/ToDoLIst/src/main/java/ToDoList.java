import models.Task;
import repositories.TaskRepository;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {
  private JFrame mainFrame;
  private JPanel titlePanel;
  private JPanel contentPanel;

  private JLabel titleLabel;

  private TaskRepository taskRepository;
  public static void main(String[] args) {
    ToDoList application = new ToDoList();
    application.run();
  }

  public ToDoList() {
    this.taskRepository = new TaskRepository();
  }

  public void run() {
    initFrame();
    initTitlePanel();
    initContentPanel();

    mainFrame.setVisible(true);
  }

  public void initFrame() {
    mainFrame = new JFrame("Todo List");
    mainFrame.setSize(300,500);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void initTitlePanel() {
    titlePanel = new JPanel();
    titlePanel.setLayout(new BorderLayout());

    titleLabel = new JLabel("할 일 목록");

    titlePanel.add(titleLabel, BorderLayout.PAGE_START);
    titlePanel.add(formPanel());

    mainFrame.add(titlePanel, BorderLayout.PAGE_START);
  }

  private JPanel formPanel() {
    JPanel formPanel = new JPanel();

    formPanel.add(new JLabel("할 일:"));

    JTextField inputTodoTextField = new JTextField(10);
    formPanel.add(inputTodoTextField);

    JButton addButton = new JButton("추가");
    addButton.addActionListener(event -> {
      String todo = inputTodoTextField.getText();
      taskRepository.addTask(new Task(todo));
      inputTodoTextField.setText("");
      TasksPanel tasksPanel = new TasksPanel(new Task(todo), taskRepository);

      showContentPanel(tasksPanel);
    });
    formPanel.add(addButton);

    return formPanel;
  }

  public void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    mainFrame.add(contentPanel);
  }
}
