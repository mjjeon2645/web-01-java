package models;

public class Task {
  public final static String[] STATE_TYPES = {"ADDED", "DONE", "DELETED"};
  private String creationTime;
  private String taskTitle;
  private String state;

  public String taskTitle() {
    return taskTitle;
  }

  public String creationTime() {
    return creationTime;
  }

  public String state() {
    return state;
  }

  public Task(String taskTitle, String creationTime, String state) {
    this.taskTitle = taskTitle;
    this.creationTime = creationTime;
    this.state = state;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object other) {
    Task otherTask = (Task) other;
    return this.taskTitle.equals(otherTask.taskTitle)
        && this.creationTime.equals(otherTask.creationTime)
        && this.state.equals(otherTask.state);
  }

  @Override
  public String toString() {
    return "Task(할일제목: " + taskTitle + ", 생성시각: "
        + creationTime + ", 상태: " + state + ")";
  }

  public void stateAdded() {
    this.state = "ADDED";
  }

  public void stateDone() {
    this.state = "DONE";
  }

  public void stateDeleted() {
    this.state = "DELETED";
  }

  public String toCsvRow() {
    return taskTitle + "," + creationTime + ","+ state;
  }
}
