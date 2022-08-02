package models;

public class Task {
  private String title;
  private String state;

  public Task(String title, String state) {
    this.title = title;
    this.state = "PROCESSING";
  }

  public String title() {
    return title;
  }

  public String state() {
    return state;
  }

  public boolean equals(Object other) {
    Task otherTask = (Task) other;
    return (this.title().equals(otherTask.title())
        && this.state.equals(otherTask.state()));
  }
}
