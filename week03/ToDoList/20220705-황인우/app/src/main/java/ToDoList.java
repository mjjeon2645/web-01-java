import javax.swing.*;
import java.awt.*;

public class ToDoList {
  private JFrame frame;
  private JPanel titlePanel;
  private JPanel mainPanel;
  private JPanel formPanel;
  private JPanel toDoListPanel;

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

  private void createFrame() {
    frame = new JFrame("Todo List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 600);
    frame.setLocation(100, 75);
  }

  private void initTitlePanel() {
    titlePanel = new JPanel();
    titlePanel.setBackground(Color.CYAN);     //Just for layout debugging

    JLabel titleLabel = new JLabel("할 일 목록");
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    titlePanel.add(titleLabel, BorderLayout.PAGE_START);

    frame.add(titlePanel, BorderLayout.PAGE_START);
  }

  private void initMainPanel() {
    mainPanel = new JPanel();
    mainPanel.setBackground(Color.RED);
    mainPanel.setLayout(new BorderLayout());

    initFormPanel();
    initToDoListPanel();

    frame.add(mainPanel);
  }

  private void initFormPanel() {
    formPanel = new JPanel();
    formPanel.setBackground(Color.ORANGE);
    formPanel.setLayout(new FlowLayout());

    formPanel.add(new JLabel("할 일: "));

    JTextField textField = new JTextField(15);
    formPanel.add(textField);

    JButton submitButton = new JButton("추가");
    submitButton.addActionListener(event -> {

    });
    formPanel.add(submitButton);

    mainPanel.add(formPanel, BorderLayout.PAGE_START);
  }

  private void initToDoListPanel() {
    toDoListPanel = new JPanel();
    toDoListPanel.setBackground(Color.YELLOW);
    toDoListPanel.setLayout(new BoxLayout(toDoListPanel, BoxLayout.Y_AXIS));

    toDoListPanel.add(new JLabel("할일 목록 1"));
    toDoListPanel.add(Box.createVerticalStrut(10));
    toDoListPanel.add(new JLabel("할일 목록 2"));
    toDoListPanel.add(Box.createVerticalStrut(10));
    toDoListPanel.add(new JLabel("할일 목록 3"));
    toDoListPanel.add(Box.createVerticalStrut(10));

    mainPanel.add(toDoListPanel);
  }
}
