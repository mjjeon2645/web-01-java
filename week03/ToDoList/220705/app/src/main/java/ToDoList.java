// 프레임 과 패널 구조 생각 -> 설정
// 모든 구조는 일단 패널들로 짬

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class ToDoList {
  private List<String> numberOfButtons = new ArrayList<>();;

  public static void main(String[] args) {
      ToDoList application = new ToDoList();
      application.run();
  }

  public void run() {

    JFrame frame = new JFrame("Todo List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,600);

    frame.getContentPane().setBackground(Color.lightGray);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    frame.add(mainPanel);

    //메인 제목 레이블
    JLabel label = new JLabel("할 일 목록");
    frame.add(label,BorderLayout.PAGE_START);
    label.setHorizontalAlignment(JLabel.CENTER);



    //메뉴 패널
    JPanel menuPanel = new JPanel();
    mainPanel.add(menuPanel,BorderLayout.NORTH);

    JLabel label1 = new JLabel("할 일");
    menuPanel.add(label1);

    JTextField textField = new JTextField(10);
    menuPanel.add(textField);

    JButton button = new JButton("추가");
    menuPanel.add(button);

    JPanel toDoPanel = new JPanel();
    mainPanel.add(toDoPanel,BorderLayout.CENTER);

    JPanel listPanelOntoDoPanel = new JPanel();
    listPanelOntoDoPanel.setLayout(new GridLayout(numberOfButtons.size(),1));
    toDoPanel.add(listPanelOntoDoPanel);




    button.addActionListener(event -> {

      JPanel pairPanel = new JPanel();
      pairPanel.setLayout(new GridLayout(1,2));

      JCheckBox toDoCheckBox = new JCheckBox(textField.getText());
      pairPanel.add(toDoCheckBox);

      JButton xButton = new JButton(" X ");
      xButton.addActionListener(xEvent -> {
        listPanelOntoDoPanel.remove(pairPanel);
        listPanelOntoDoPanel.setVisible(false);
        listPanelOntoDoPanel.setVisible(true);

        numberOfButtons.add("button");
      });

      pairPanel.add(xButton);

      listPanelOntoDoPanel.add(pairPanel);

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



    frame.setVisible(true);

  });








    frame.setVisible(true);

  }
}
