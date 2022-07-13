package models;

// TODO. task에 대한 정의
// TODO. task의 상태값 바꿔주기?

public class Task {
  public final static String[] STATETYPES = {"ADDED", "DONE", "DELETED"};
  private String taskTitle;
  private String creationTime;
  private String state;

  public Task(String taskTitle, String creationTime, String state) {

    this.taskTitle = taskTitle;
    this.creationTime = creationTime;
    this.state = state;
  }

  public String values() {
    return null;
  }

  public String csvRow() {
    return null;
  }
}
