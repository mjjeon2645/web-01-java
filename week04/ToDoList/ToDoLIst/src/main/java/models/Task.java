package models;

public class Task {

  private String title;

  public Task(String title) {
    this.title = title;
  }

  public String title() {
    return title;
  }

  @Override
  public String toString() {
    return title;
  }
}
