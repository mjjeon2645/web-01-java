package models;

public class Task {
  private static final String PROCESSING = "PROCESSING";
  private static final String COMPLETION = "COMPLETION";
  private static final String DELETION = "DELETION";

  private String title;
  private String state;

  public Task(String title, String state) {
    this.title = title;
    this.state = state;
  }

  public Task(String title) {
    this.title = title;
    this.state = Task.PROCESSING;
  }

  public String title() {
    return title;
  }

  public String state() {
    return state;
  }

  public void processing() {
    this.state = Task.PROCESSING;
  }

  public void complete() {
    this.state = Task.COMPLETION;
  }

  public void delete() {
    this.state = Task.DELETION;
  }

  @Override
  public String toString() {
    return title;
  }

  public String toCsvRow() {
    return title + "," + state;
  }
}
