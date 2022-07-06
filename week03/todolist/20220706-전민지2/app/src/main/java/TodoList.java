import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TodoList {
  private JFrame frame;
  private JPanel contentPanel;
  private JPanel displayTasksPanel;
  private JPanel titleAndFormContainerPanel;
  private JPanel formPanel;
  private JTextField textField;

  public static void main(String[] args) {
    TodoList application = new TodoList();
    application.run();
  }

  public void run() {
    // frame 세팅
    initFrame();

    // 컨텐트 패널 세팅
    initContentPanel();

    // 상단 타이틀 및 폼
    initTitleAndForm();

    // task 목록들이 노출되는 패널 실현
    initDisplayTasksPanel();
  }

  public void initTitleAndForm() {
    // 타이틀과 폼을 묶어주는 컨테이너 패널 생성
    initTitleAndFormContainer();

    // 타이틀 생성 및 세팅
    initTitle();

    // form(소제목, 텍스트필드, 할일 추가버튼) 세팅
    initFormComponentsContainer();

    initSubtitleInForm();

    initTextFieldInForm();

    JButton addButton = new JButton("추가");
    addButton.addActionListener(addEvent -> {
      String text = textField.getText();

      // 1개의 Task에 대한 컴포넌트를 묶어줄 패널 세팅 및 컴포넌트 추가
      JPanel taskComponentContainerPanel = new JPanel();
      taskComponentContainerPanel.setBackground(Color.GREEN);
      displayTasksPanel.add(taskComponentContainerPanel);

      JCheckBox checkBox = new JCheckBox();
      taskComponentContainerPanel.add(checkBox);

      JLabel taskTitleLabel = new JLabel(text);
      taskTitleLabel.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
          if (checkBox.isSelected()) {
            checkBox.setSelected(false);
            return;
          }
            checkBox.setSelected(true);
          }
      });

      taskComponentContainerPanel.add(taskTitleLabel);

      initDeleteTaskButton(taskComponentContainerPanel);

      showContentPanel();
    });
    formPanel.add(addButton);
  }

  public void initFrame() {
    frame = new JFrame("Todo List");
    frame.setBackground(Color.cyan);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 600);
    frame.setVisible(true);
  }

  public void initTitleAndFormContainer() {
    titleAndFormContainerPanel = new JPanel();
    titleAndFormContainerPanel.setLayout(new BorderLayout());
    frame.add(titleAndFormContainerPanel, BorderLayout.PAGE_START);
  }

  public void initTitle() {
    JLabel titleLabel = new JLabel("할 일 목록");
    titleLabel.setHorizontalAlignment(JTextField.CENTER);
    titleAndFormContainerPanel.add(titleLabel, BorderLayout.PAGE_START);
  }

  public void initFormComponentsContainer() {
    formPanel = new JPanel();
    formPanel.setBackground(Color.pink);
    titleAndFormContainerPanel.add(formPanel);
  }

  public void initSubtitleInForm() {
    JLabel subtitleLabel = new JLabel("할 일: ");
    formPanel.add(subtitleLabel);
  }

  public void initTextFieldInForm() {
    textField = new JTextField(10);
    formPanel.add(textField);
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    contentPanel.setBackground(Color.yellow);
    frame.add(contentPanel);
  }

  public void initDeleteTaskButton(JPanel taskComponentContainerPanel) {
    JButton deleteTaskButton = new JButton("X");
    deleteTaskButton.addActionListener(deleteEvent -> {
      displayTasksPanel.remove(taskComponentContainerPanel);
      displayTasksPanel.setVisible(false);
      displayTasksPanel.setVisible(true);
    });
    taskComponentContainerPanel.add(deleteTaskButton);
  }

  public void showContentPanel() {
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }

  public void initDisplayTasksPanel() {
    displayTasksPanel = new JPanel();
    displayTasksPanel.setBackground(Color.DARK_GRAY);
    displayTasksPanel.setLayout(new GridLayout(0, 1));
    contentPanel.add(displayTasksPanel);
  }
}
