package models;

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

  public Task(String taskTitle, String timeStamp) {
    this.taskTitle = taskTitle;
    this.timeStamp = timeStamp;
    this.state = "PROCESSING";
  }

  public Task(String taskTitle, String timeStamp, String state) {
    this.taskTitle = taskTitle;
    this.timeStamp = timeStamp;
    this.state = state;
  }

  public void processing() {
    this.state = "PROCESSING";
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
