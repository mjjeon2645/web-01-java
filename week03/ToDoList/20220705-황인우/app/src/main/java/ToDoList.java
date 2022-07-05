import models.ToDo;
import panels.FormPanel;
import panels.ToDoListPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class ToDoList {
  private final List<ToDo> toDoList;

  private JFrame frame;
  private JPanel titlePanel;
  private JPanel mainPanel;
  private FormPanel formPanel;
  private ToDoListPanel toDoListPanel;

  public ToDoList() {
    toDoList = new ArrayList<>();
  }

  public static void main(String[] args) {
    ToDoList application = new ToDoList();
    application.run();
  }

  public void run() {
    createFrame();

    initTitlePanel();
    initMainPanel();

    frame.setVisible(true);
  }

  public void createFrame() {
    frame = new JFrame("Todo List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 600);
    frame.setLocation(100, 75);
  }

  public void initTitlePanel() {
    titlePanel = new JPanel();
    //titlePanel.setBackground(Color.CYAN);     //Just for layout debugging

    JLabel titleLabel = new JLabel("할 일 목록");
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    titlePanel.add(titleLabel, BorderLayout.PAGE_START);

    frame.add(titlePanel, BorderLayout.PAGE_START);
  }

  public void initMainPanel() {
    mainPanel = new JPanel();
    //mainPanel.setBackground(Color.RED);
    mainPanel.setLayout(new BorderLayout());

    initSubPanelsOfMainPanel();

    frame.add(mainPanel);
  }

  public void initSubPanelsOfMainPanel() {
    toDoListPanel = new ToDoListPanel(toDoList);
    //toDoListPanel.setBackground(Color.YELLOW);
    formPanel = new FormPanel(toDoList, toDoListPanel);

    mainPanel.add(formPanel, BorderLayout.PAGE_START);
    mainPanel.add(toDoListPanel);
  }
}
