package application;

import panels.InputPanel;
import panels.TasksPanel;
import repositories.TaskRepository;

import javax.swing.*;
import java.awt.*;

public class ToDoList {
  private TaskRepository taskRepository;

  private JFrame frame;
  private JPanel contentPanel;
  private InputPanel inputPanel;

  public static void main(String[] args) {
    ToDoList application = new ToDoList();
    application.run();
  }

  public ToDoList() {
    taskRepository = new TaskRepository();
  }

  public void run() {
    initFrame();
    initTitle();
    initContentPanel();

    frame.setVisible(true);
  }

  public void initFrame() {
    frame = new JFrame("Todo List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(350, 700);
    frame.setLocation(100, 70);
  }

  public void initTitle() {
    JLabel titleLabel = new JLabel("할 일 목록");
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    frame.add(titleLabel, BorderLayout.PAGE_START);
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    contentPanel.setLayout(new BorderLayout());
    contentPanel.setBackground(Color.PINK);

    inputPanel = new InputPanel(contentPanel, tasksPanel, taskRepository);
    TasksPanel tasksPanel = new TasksPanel(this, contentPanel, taskRepository);

    frame.add(contentPanel);
  }

  public void showContentPanel(JPanel tasksPanel) {
    contentPanel.removeAll();
    inputPanel.initInputPanel();
    contentPanel.add(tasksPanel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }
}
