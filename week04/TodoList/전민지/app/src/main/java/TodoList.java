import models.Tasks;
import panels.FormPanel;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class TodoList {
  private Tasks tasks;

  private JFrame frame;
  private JPanel headerPanel;
  private JPanel contentPanel;

  public static void main(String[] args) throws FileNotFoundException {
    TodoList application = new TodoList();
    application.run();
  }

  public TodoList() throws FileNotFoundException {
    tasks = new Tasks();
  }

  public void run() {
    initFrame();

    initHeader();

    initContentPanel();
  }

  public void initFrame() {
    frame = new JFrame("Todo List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 600);
    frame.setVisible(true);
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    frame.add(contentPanel);
    frame.setVisible(true);
  }

  public void initHeader() {
    initHeaderPanel();

    initTitleLabel();

    initForm();
  }

  public void initHeaderPanel() {
    headerPanel = new JPanel();
    headerPanel.setLayout(new BorderLayout());
    frame.add(headerPanel, BorderLayout.PAGE_START);
  }

  public void initTitleLabel() {
    JLabel titleLabel = new JLabel("할 일 목록");
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    headerPanel.add(titleLabel, BorderLayout.PAGE_START);
  }

  public void initForm() {
    FormPanel formPanel = new FormPanel(tasks);
    headerPanel.add(formPanel);
  }

  public void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);

    panel.setVisible(false);
    panel.setVisible(true);

    frame.setVisible(true);
  }
}
