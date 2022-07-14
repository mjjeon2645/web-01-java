package models;

public class Task {
  private static final String PROCESSING = "PROCESSING";
  private static final String COMPLETION = "COMPLETION";
  private static final String DELETION = "DELETION";

  private String title;
  private String state;

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

  public void updateTaskStateProcessing() {
    this.state = PROCESSING;
  }

  public void updateTaskStateCompletion() {
    this.state = COMPLETION;
  }

  public void updateTaskStateDeletion() {
    this.state = DELETION;
  }

  @Override
  public String toString() {
    return title;
  }

  public String toCsvRow() {
    return title + "," + state;
  }
}
