import javax.swing.*;

public class TodoPanel extends JPanel {
  private final JCheckBox checkBox;
  private final JLabel taskLabel;
  private final JButton deleteButton;

  TodoPanel() {
    checkBox = new JCheckBox();
    this.add(checkBox);

    taskLabel = new JLabel("안녕하세용");
    this.add(taskLabel);

    deleteButton = new JButton("X");
    deleteButton.addActionListener(event -> {
      deleteTodo();
    });
    this.add(deleteButton);
  }

  private void deleteTodo() {
    this.remove(checkBox);
    this.remove(taskLabel);
    this.remove(deleteButton);
    this.setVisible(false);
    this.setVisible(true);
  }
}
