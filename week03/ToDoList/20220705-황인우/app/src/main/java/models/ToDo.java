package models;

public class ToDo {
  private final String detail;
  private boolean isCompleted = false;
  private boolean isValid = true;

  public ToDo(String detail) {
    this.detail = detail;
  }

  public String detail() {
    return this.detail;
  }

  public boolean isCompleted() {
    return this.isCompleted;
  }

  public boolean isValid() {
    return this.isValid;
  }

  public void changeState() {
    this.isCompleted = !isCompleted;
  }

  public void invalidate() {
    this.isValid = false;
  }
}
