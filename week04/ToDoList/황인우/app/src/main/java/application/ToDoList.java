package application;

import models.Task;
import panels.InputPanel;
import panels.TasksPanel;
import utils.FileReader;
import utils.FileWriter;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.awt.*;

public class ToDoList {
  private final List<Task> tasks;

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

    tasks = fileReader.loadTasks();
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
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent event) {
        FileWriter fileWriter = new FileWriter();

        try {
          fileWriter.saveTasks(tasks);
        } catch (IOException exception) {
          throw new RuntimeException(exception);
        }
      }
    });

    frame.setSize(350, 700);
    frame.setLocation(100, 70);
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    contentPanel.setLayout(new BorderLayout());
    contentPanel.setBackground(Color.PINK);

    tasksPanel = new TasksPanel(tasks, this);

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

    createTitleLabel();
    createInputPanel();

    frame.add(headerPanel, BorderLayout.PAGE_START);
  }

  public void createTitleLabel() {
    JLabel titleLabel = new JLabel("할 일 목록");
    titleLabel.setHorizontalAlignment(JLabel.CENTER);

    headerPanel.add(titleLabel, BorderLayout.PAGE_START);
  }

  public void createInputPanel() {
    JPanel inputPanel = new InputPanel(tasks, tasksPanel);

    headerPanel.add(inputPanel);
  }
}
