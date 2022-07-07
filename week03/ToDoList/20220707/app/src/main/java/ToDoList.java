// 메인클래스 -> 클래스 객체 생성 -> 객체 안에서 불러올 객체 변수. 변수
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class ToDoList {
  private JFrame frame;
  private JPanel backgroundPanel;


  private JButton button;
  private JPanel taskListPanel = new JPanel();
  private JPanel contentPanel;
  private TaskRegisterPanel taskRegisterPanel;


  public static void main(String[] args) {
    ToDoList application = new ToDoList();
    application.run();
  }

  public void run() {


    createFrame();

    createBackgroundPanel();

    createTodoTitleLabel();

    taskRegisterPanel = new TaskRegisterPanel(taskListPanel);



    backgroundPanel.add(taskRegisterPanel, BorderLayout.NORTH);

    createContentPanel();

    createTaskListPanel();

    //프레임 보여주기
    frame.setVisible(true);

  }

  public void createFrame() {
    //프레임 생성
    frame = new JFrame("Todo List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,600);

    frame.getContentPane().setBackground(Color.lightGray);
  }

  public void createTodoTitleLabel() {
    //메인 제목 레이블
    JLabel label = new JLabel("할 일 목록");
    frame.add(label,BorderLayout.PAGE_START);
    label.setHorizontalAlignment(JLabel.CENTER);
  }

  public void createBackgroundPanel() {
    //메인 패널 생성 레이아웃 설정
    backgroundPanel = new JPanel();
    backgroundPanel.setLayout(new BorderLayout());
    frame.add(backgroundPanel);
  }

  public void createTaskListPanel() {

    taskListPanel.setLayout(new GridLayout(TaskPanel.numberOfButtons.size() ,1));
    contentPanel.add(taskListPanel);
  }

  public void createContentPanel() {
    contentPanel = new JPanel();
    backgroundPanel.add(contentPanel,BorderLayout.CENTER);
  }





}