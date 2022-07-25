package panels;

import models.ToDo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FormPanel extends JPanel {
  public FormPanel(List<ToDo> toDoList, ToDoListPanel toDoListPanel) {
    //formPanel.setBackground(Color.ORANGE);
    this.setLayout(new FlowLayout());

    this.add(new JLabel("할 일: "));

    JTextField textField = new JTextField(10);
    this.add(textField);

    JButton submitButton = new JButton("추가");
    submitButton.addActionListener(event -> {
      toDoList.add(new ToDo(textField.getText()));
      toDoListPanel.resetToDoListPanel();

      textField.setText("");
    });
    this.add(submitButton);
  }

}
