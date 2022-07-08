import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class TaskPanel extends JPanel {
  public static List<String> numberOfButtons = new ArrayList<>();
  //수정 변수
  private JButton deleteButton;
  private JPanel taskListPanel;
  private JTextField todoTextField;

  private JCheckBox todoCheckBox;


  TaskPanel(JPanel taskListPanel, JTextField todoTextField) {
    this.taskListPanel = taskListPanel;
    this.todoTextField = todoTextField;

    this.setLayout(new GridLayout(1, 2));

    createCheckBox();

    createDeleteButton();

    taskListPanel.add(this);

  }

  public void createCheckBox() {
    todoCheckBox = new JCheckBox(todoTextField.getText());
    this.add(todoCheckBox);

    addMouseListener();
  }


  public void addMouseListener() {
    todoCheckBox.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent event) {
        if (todoCheckBox.isSelected()) {
          todoCheckBox.setSelected(false);
        }
        if (!todoCheckBox.isSelected()) {
          todoCheckBox.setSelected(true);
        }
      }
    });
  }

  public void createDeleteButton() {

    deleteButton = new JButton(" X ");
    deleteButton.addActionListener(deleteEvent -> {
      taskListPanel.remove(this);
      taskListPanel.setVisible(false);
      taskListPanel.setVisible(true);
    });
    numberOfButtons.add("button");
    this.add(deleteButton);
  }
}
