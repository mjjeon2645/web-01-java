package models;

public class Task {
  public static final String TO_DO = "TO_DO";
  public static final String DONE = "DONE";
  public static final String DELETED = "DELETED";

  private final String text;
  private String status;

  public Task(String text) {
    this.text = text;
    this.status = TO_DO;
  }

  public String text() {
    return this.text;
  }

  public String status() {
    return this.status;
  }

  public void setStatusToDo() {
    this.status = TO_DO;
  }

  public void setStatusDone() {
    this.status = DONE;
  }

  public void setStatusDeleted() {
    this.status = DELETED;
  }
}
