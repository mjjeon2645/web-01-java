package models;

public class Task {
  private final String text;

  public Task(String text) {
    this.text = text;
  }
  public String task() {
    return text;
  }
}
