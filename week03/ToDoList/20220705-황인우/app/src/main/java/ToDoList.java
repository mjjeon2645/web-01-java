import models.ToDo;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class ToDoList {
  private List<ToDo> toDoList;

  private JFrame frame;
  private JPanel titlePanel;
  private JPanel mainPanel;
  private JPanel formPanel;
  private JPanel toDoListPanel;

  public static void main(String[] args) {
    ToDoList application = new ToDoList();
    application.run();
  }

  public ToDoList() {
    toDoList = new ArrayList<>();
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

    initFormPanel();
    initToDoListPanel();

    frame.add(mainPanel);
  }

  public void initFormPanel() {
    formPanel = new JPanel();
    //formPanel.setBackground(Color.ORANGE);
    formPanel.setLayout(new FlowLayout());

    formPanel.add(new JLabel("할 일: "));

    JTextField textField = new JTextField(10);
    formPanel.add(textField);

    JButton submitButton = new JButton("추가");
    submitButton.addActionListener(event -> {
      toDoList.add(new ToDo(textField.getText()));
      resetToDoListPanel();
    });
    formPanel.add(submitButton);

    mainPanel.add(formPanel, BorderLayout.PAGE_START);
  }

  public void initToDoListPanel() {
    toDoListPanel = new JPanel();
    //toDoListPanel.setBackground(Color.YELLOW);

    createListOfToDoLists();

    mainPanel.add(toDoListPanel);
  }

  public void resetToDoListPanel() {
    toDoListPanel.removeAll();

    createListOfToDoLists();

    toDoListPanel.setVisible(false);
    toDoListPanel.setVisible(true);
  }

  public void createListOfToDoLists() {
    toDoListPanel.setLayout(new GridLayout(toDoList.size(), 1));
    for (ToDo toDo : toDoList) {
      if (toDo.isValid()) {
        JPanel eachToDoPanel = new JPanel();

        JCheckBox checkBox = new JCheckBox(
            "", toDo.isCompleted()
        );
        checkBox.addActionListener(event -> {
          toDo.changeState();
        });
        eachToDoPanel.add(checkBox);

        JLabel detailLabel = new JLabel(toDo.detail());
        detailLabel.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent event) {
            toDo.invalidate();
            resetToDoListPanel();
          }
        });
        eachToDoPanel.add(detailLabel);

        JButton invalidateButton = new JButton("X");
        invalidateButton.addActionListener(event -> {
          toDo.invalidate();
          resetToDoListPanel();
        });
        eachToDoPanel.add(invalidateButton);

        toDoListPanel.add(eachToDoPanel);
      }
    }
  }
}
