package models;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Task {
  public final static int DELETED = 0;
  public final static int PROCESSING = 1;
  public final static int DONE = 2;

  private String timeStamp;
  private String taskTitle;
  private int state;

  public String taskTitle() {
    return taskTitle;
  }

  public int state() {
    return state;
  }

  public Task(String taskTitle) {
    LocalDateTime localDateTime = LocalDateTime.now();
    String timeStamp = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    this.timeStamp = timeStamp;
    this.taskTitle = taskTitle;
    this.state = PROCESSING;
  }

  public Task(String taskTitle, String timeStamp, int state) {
    this.taskTitle = taskTitle;
    this.timeStamp = timeStamp;
    this.state = state;

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void processing() {
    this.state = PROCESSING;
  }

  public void done() {
    this.state = DONE;
  }

  public void deleted() {
    this.state = DELETED;
  }

  public String toCsvRow() {
    return taskTitle + "," + timeStamp + "," + state;
  }

  public int hashCode() {
    return 0;
  }

  public boolean equals(Object other) {
    Task otherTask = (Task) other;
    return Objects.equals(this.taskTitle, otherTask.taskTitle)
        && Objects.equals(this.timeStamp, otherTask.timeStamp)
        && this.state == otherTask.state;
  }
}
