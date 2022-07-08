import javax.swing.*;
import java.awt.*;

public class TodoList {
  private JFrame frame;
  private JPanel contentPanel;

  public static void main(String[] args) {
    TodoList application = new TodoList();
    application.run();
  }

  public void run() {
    frame = new JFrame("Todo List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 600);

    JPanel titleAndFormPanel = new JPanel();
    titleAndFormPanel.setLayout(new BorderLayout());
    frame.add(titleAndFormPanel, BorderLayout.PAGE_START);

    JLabel titleLabel = new JLabel("할 일 목록");
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    titleAndFormPanel.add(titleLabel, BorderLayout.PAGE_START);

    JPanel formPanel = new JPanel();
    titleAndFormPanel.add(formPanel);

    JLabel subTitle = new JLabel("할 일: ");
    formPanel.add(subTitle);

    JTextField textField = new JTextField(10);
    formPanel.add(textField);

    JButton addTaskButton = new JButton("추가");
    addTaskButton.addActionListener(event -> {
      TasksPanel tasksPanel = new TasksPanel();

      contentPanel.removeAll();
      contentPanel.add(tasksPanel);

      contentPanel.setVisible(false);
      contentPanel.setVisible(true);

      frame.setVisible(true);
    });
    formPanel.add(addTaskButton);

    contentPanel = new JPanel();
    frame.add(contentPanel);

    frame.setVisible(true);
  }
}
