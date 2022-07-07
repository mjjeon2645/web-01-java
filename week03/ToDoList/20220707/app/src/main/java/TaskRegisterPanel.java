import javax.swing.*;

public class TaskRegisterPanel extends JPanel {
    private JTextField todoTextField;





  TaskRegisterPanel(JPanel taskListPanel) {



    JLabel label = new JLabel("할 일");
    this.add(label);

    todoTextField = new JTextField(10);
    this.add(todoTextField);

    JButton button = new JButton("추가");
    this.add(button);

    //할일 추가 버튼을 눌렀을 때 액션
    button.addActionListener(event -> {

      TaskPanel taskPanel = new TaskPanel(taskListPanel, todoTextField);

    });
  }


}
