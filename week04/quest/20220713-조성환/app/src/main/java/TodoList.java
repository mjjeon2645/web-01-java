// 파일에서 할 일 목록을 보여 줘야 함

import models.Task;
import panels.FormPanel;
import panels.TasksPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TodoList {
  private final List<Task> tasks;
  private JFrame frame;
  private JPanel mainPanel;
  private TasksPanel tasksPanel;

  public static void main(String[] args) {
    TodoList application = new TodoList();
    application.run();
  }

  public TodoList() {
    // todolist를 실행하면 csv파일에 저장되 있던 내용을 load한 뒤에 tasksPanel에
    // 출력해 줘야함
    tasks = new ArrayList<>();
  }

  private void run() {
    createFrame();

    initTitlePanel();

    initMainPanel();

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
    titlePanel.setBackground(Color.blue);
  }

  private void initMainPanel() {
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());

    tasksPanel = new TasksPanel(tasks);
    FormPanel formPanel = new FormPanel(tasks, tasksPanel);

    mainPanel.add(formPanel, BorderLayout.PAGE_START);
    mainPanel.add(tasksPanel);
    frame.add(mainPanel);
    tasksPanel.setBackground(Color.cyan);
    mainPanel.setBackground(Color.green);

  }

}
