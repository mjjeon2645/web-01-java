package models;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
  public final static String[] STATE_TYPES = {"PROCESSING", "DONE", "DELETED"};
  private String timeStamp;
  private String taskTitle;
  private String state;

  public String taskTitle() {
    return taskTitle;
  }

  public String state() {
    return state;
  }

  public Task(String taskTitle) {
    LocalDateTime localDateTime = LocalDateTime.now();
    String timeStamp = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    this.timeStamp = timeStamp;
    this.taskTitle = taskTitle;
    this.state = "PROCESSING";
  }

  public Task(String taskTitle, String timeStamp, String state) {
    this.taskTitle = taskTitle;
    this.timeStamp = timeStamp;
    this.state = state;

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void processing() {
    this.state = STATE_TYPES[0];
  }

  public void done() {
    this.state = "DONE";
  }

  public void deleted() {
    this.state = "DELETED";
  }

  public String toCsvRow() {
    return taskTitle + "," + timeStamp + ","+ state;
  }
}
