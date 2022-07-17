package models;

public class Task {
  private final String text;
  private String state;

  public static final String COMPLETE = "COMPLETE";
  public static final String DELETE = "DELETE";
  public static final String PROGRESS = "PROGRESS";

  public Task(String text, String state) {
    this.text = text;
    this.state = state;
  }

  public String task() {
    return text;
  }
  public String state() {
    return state;
  }

  public void setComplete() {
    state = COMPLETE;
  }

  public void setDelete() {
    state = DELETE;
  }

  public void setProgress() {
    state = PROGRESS;
  }

  @Override
  public String toString() {
    return text;
  }

  public String toCsvRow() {
    return text + "," + state;
  }
}
