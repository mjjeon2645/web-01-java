import models.Task;
import panels.FormPanel;
import panels.TasksPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TodoList {
  private final List<Task> tasks;
  private final TasksLoader fileloader;

  private JFrame frame;
  private JPanel mainPanel;
  private TasksPanel tasksPanel;

  public static void main(String[] args) throws FileNotFoundException {
    TodoList application = new TodoList();
    application.run();
  }

  public TodoList() throws FileNotFoundException {
    tasks = new ArrayList<>();
    fileloader = new TasksLoader(tasks);
  }

  private void run() {
    createFrame();

    initTitlePanel();

    initMainPanel();

    saveTask();

    frame.setVisible(true);
  }

  private void createFrame() {
    frame = new JFrame("Todo List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 600);
  }

  private void initTitlePanel() {
    JPanel titlePanel = new JPanel();
    JLabel titleLabel = new JLabel("할 일 목록");
    titlePanel.add(titleLabel, BorderLayout.PAGE_START);
    frame.add(titlePanel, BorderLayout.PAGE_START);
  }

  private void initMainPanel() {
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());

    tasksPanel = new TasksPanel(tasks);
    FormPanel formPanel = new FormPanel(tasks, tasksPanel);

    mainPanel.add(formPanel, BorderLayout.PAGE_START);
    mainPanel.add(tasksPanel);
    frame.add(mainPanel);
  }

  private void saveTask() {
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        try {
          TasksWriter tasksWriter = new TasksWriter(tasks);
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
  }
}
