import models.Task;
import panels.TasksPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ToDoList {
  private List<Task> tasks;

  private JFrame mainFrame;
  private JPanel titlePanel;
  private JPanel contentPanel;

  private JLabel titleLabel;

  public static void main(String[] args) throws IOException {
    ToDoList application = new ToDoList();
    application.run();
  }

  public ToDoList() throws FileNotFoundException {
    TaskLoader taskLoader = new TaskLoader();

    tasks = taskLoader.loadTasks();
  }

  public void run() throws IOException {
    initFrame();
    initTitlePanel();
    initContentPanel();

    fileWriter();

    mainFrame.setVisible(true);
  }

  public void initFrame() {
    mainFrame = new JFrame("Todo List");
    mainFrame.setSize(300, 500);
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
      tasks.add(new Task(todo));
      inputTodoTextField.setText("");

      TasksPanel tasksPanel = new TasksPanel(tasks);

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

  public void fileWriter() throws IOException {
    mainFrame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent event) {
        TaskLoader taskLoader = new TaskLoader();

        try {
          taskLoader.writeTask(tasks);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    });
  }
}
