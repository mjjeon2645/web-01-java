import models.Task;
import panels.TasksPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class TodoList {
  private List<Task> tasks;

  private JFrame mainFrame;
  private JPanel titlePanel;
  private JPanel contentPanel;

  private JLabel titleLabel;

  public static void main(String[] args) throws IOException {
    TodoList application = new TodoList();
    application.run();
  }

  public TodoList() throws FileNotFoundException {
    TaskLoader taskLoad = new TaskLoader();

    tasks = taskLoad.loadTasks();
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
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
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
        TaskWriter taskWriter = new TaskWriter();

        try {
          taskWriter.writeTask(tasks);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    });
  }
}