package application;

import models.Task;
import panels.InputPanel;
import panels.TasksPanel;
import repositories.TaskRepository;
import utils.FileReader;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.List;
import java.awt.*;

public class ToDoList {
  private TaskRepository taskRepository;

  private JFrame frame;
  private JPanel headerPanel;
  private JPanel contentPanel;

  private TasksPanel tasksPanel;

  public static void main(String[] args) throws FileNotFoundException {
    ToDoList application = new ToDoList();
    application.run();
  }

  public ToDoList() throws FileNotFoundException {
    FileReader fileReader = new FileReader();

    List<Task> tasks = fileReader.readFile();

    taskRepository = new TaskRepository(tasks);
  }

  public void run() {
    initFrame();
    initContentPanel();
    initHeaderPanel();

    frame.setVisible(true);
  }

  public void initFrame() {
    frame = new JFrame("Todo List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 700);
    frame.setLocation(100, 70);
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    contentPanel.setLayout(new BorderLayout());
    contentPanel.setBackground(Color.PINK);

    tasksPanel = new TasksPanel(taskRepository, this);

    showContentPanel(tasksPanel);

    frame.add(contentPanel);
  }

  public void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }

  public void initHeaderPanel() {
    headerPanel = new JPanel();
    headerPanel.setLayout(new BorderLayout());

    initTitleLabel();
    initInputPanel();

    frame.add(headerPanel, BorderLayout.PAGE_START);
  }

  public void initTitleLabel() {
    JLabel titleLabel = new JLabel("할 일 목록");
    titleLabel.setHorizontalAlignment(JLabel.CENTER);

    headerPanel.add(titleLabel, BorderLayout.PAGE_START);
  }

  public void initInputPanel() {
    JPanel inputPanel = new InputPanel(taskRepository, tasksPanel);

    headerPanel.add(inputPanel);
  }
}
