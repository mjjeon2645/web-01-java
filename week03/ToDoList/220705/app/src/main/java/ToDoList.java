// 프레임 과 패널 구조 생각 -> 설정
// 모든 구조는 일단 패널들로 짬

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class ToDoList {
  private List<String> numberOfButtons = new ArrayList<>();;

  private JFrame frame;
  private JTextField textField;
  private JButton addTodoButton;
  private JPanel mainPanel;
  private JPanel contentPanel;
  private JPanel listPanelOnContentPanel;
  //private JPanel pairPanel;
  private JCheckBox toDoCheckBox;
 // private List<JPanel> pairPanels = new ArrayList<>();
 // private List<JButton> xButtons = new ArrayList<>();

  public static void main(String[] args) {
      ToDoList application = new ToDoList();
      application.run();
  }

  public void run() {

    frame = new JFrame("Todo List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,600);

    frame.getContentPane().setBackground(Color.lightGray);

    //프레임에 바탕 패널 깔아주기
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    frame.add(mainPanel);


    //메인 제목 레이블
    titilePanel();

    //메뉴 패널
    initAddTodoPanel();

    initContentPanel();

    createListPanel();


    addTodoButton.addActionListener(event -> {
      JPanel pairPanel = new JPanel();
     // createPairPanel();

      pairPanel.setLayout(new GridLayout(1,2));

      toDoCheckBox = new JCheckBox(textField.getText());
      pairPanel.add(toDoCheckBox);

      JButton xButton = new JButton(" X ");
      xButton.addActionListener(xEvent -> {
       // updateDisplay();

        listPanelOnContentPanel
            .remove(pairPanel);
        listPanelOnContentPanel
            .setVisible(false);
        listPanelOnContentPanel
            .setVisible(true);

       // addNumberOfButtons();
        numberOfButtons.add("button");
      });


      pairPanel.add(xButton);

      listPanelOnContentPanel
          .add(pairPanel);

      addActionOnCheckBox();


      frame.setVisible(true);

  });

    frame.setVisible(true);

  }

  private void initAddTodoPanel() {
    JPanel menuPanel = new JPanel();
    mainPanel.add(menuPanel,BorderLayout.NORTH);

    JLabel label1 = new JLabel("할 일");
    menuPanel.add(label1);

    textField = new JTextField(10);
    menuPanel.add(textField);

    addTodoButton = new JButton("추가");
    menuPanel.add(addTodoButton);
  }

  private void initContentPanel() {
    contentPanel
        = new JPanel();
    mainPanel.add(contentPanel
        ,BorderLayout.CENTER);
  }

  private void createListPanel() {
    listPanelOnContentPanel = new JPanel();
    listPanelOnContentPanel
        .setLayout(new GridLayout(numberOfButtons.size(),1));
    contentPanel
        .add(listPanelOnContentPanel
        );
  }

 /* private void createPairPanel() {
    pairPanel = new JPanel();
    pairPanel.setLayout(new GridLayout(1,2));
  }
*/
  private void addActionOnCheckBox() {
    toDoCheckBox.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent event) {
        if (toDoCheckBox.isSelected()) {
          toDoCheckBox.setSelected(false);
        }
        if (!toDoCheckBox.isSelected()) {
          toDoCheckBox.setSelected(true);
        }
      }
  });
  }

  public void addNumberOfButtons() {
    numberOfButtons.add("button");
  }

/*  public void updateDisplay() {
    listPanelOnContentPanel
        .remove(pairPanel);
    listPanelOnContentPanel
        .setVisible(false);
    listPanelOnContentPanel
        .setVisible(true);
  }*/

  private void titilePanel() {
    JLabel label = new JLabel("할 일 목록");
    frame.add(label,BorderLayout.PAGE_START);
    label.setHorizontalAlignment(JLabel.CENTER);
  }
}
