package panels;

import models.ToDo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ToDoListPanel extends JPanel {
  private final List<ToDo> toDoList;

  public ToDoListPanel(List<ToDo> toDoList) {
    this.toDoList = toDoList;

    this.createListOfToDoLists();
  }

  public void createListOfToDoLists() {
    this.setLayout(new GridLayout(toDoList.size(), 1));
    for (ToDo toDo : toDoList) {
      if (toDo.isValid()) {
        JPanel eachToDoPanel = new JPanel();

        eachToDoPanel.add(createCheckBox(toDo));
        eachToDoPanel.add(createDetailLabel(toDo));
        eachToDoPanel.add(createInvalidationButton(toDo));

        this.add(eachToDoPanel);
      }
    }
  }

  public JCheckBox createCheckBox(ToDo toDo) {
    JCheckBox checkBox = new JCheckBox("", toDo.isCompleted());

    checkBox.addActionListener(event -> {
      toDo.changeState();
    });

    return checkBox;
  }

  public JLabel createDetailLabel(ToDo toDo) {
    JLabel detailLabel = new JLabel(toDo.detail());

    detailLabel.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent event) {
        toDo.invalidate();
        resetToDoListPanel();
      }
    });

    return detailLabel;
  }

  public JButton createInvalidationButton(ToDo toDo) {
    JButton invalidationButton = new JButton("X");

    invalidationButton.addActionListener(event -> {
      toDo.invalidate();
      resetToDoListPanel();
    });

    return invalidationButton;
  }

  public void resetToDoListPanel() {
    this.removeAll();

    this.createListOfToDoLists();

    this.setVisible(false);
    this.setVisible(true);
  }
}
