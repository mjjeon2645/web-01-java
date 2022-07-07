import javax.swing.*;
import java.awt.*;

public class TodoList {
  private JFrame frame;
  private JPanel titleAndFormPanel;

  public static void main(String[] args) {
    TodoList application = new TodoList();
    application.run();
  }

  public void run() {
    initFrame();

    initTitleAndForm();

    initContentPanel();

    frame.setVisible(true);
  }

  public void initFrame() {
    frame = new JFrame("Todo List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 600);
  }

  public void initTitleAndForm() {
    titleAndFormPanel = new JPanel();
    titleAndFormPanel.setLayout(new BorderLayout());
    frame.add(titleAndFormPanel, BorderLayout.PAGE_START);

    JLabel titleLabel = new JLabel("할 일 목록");
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    titleAndFormPanel.add(titleLabel, BorderLayout.PAGE_START);

    JPanel formPanel = new JPanel();
    titleAndFormPanel.add(formPanel);

    JLabel subtitleLabel = new JLabel("할 일: ");
    formPanel.add(subtitleLabel);

    JTextField textField = new JTextField(10);
    formPanel.add(textField);

    JButton addTaskButton = new JButton("추가");
    formPanel.add(addTaskButton);
  }

  public void initContentPanel() {
    JPanel contentPanel = new JPanel();
    frame.add(contentPanel);
  }
}
