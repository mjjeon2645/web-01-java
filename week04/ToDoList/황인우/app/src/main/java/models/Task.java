package models;

public class Task {
  public static final String PROCESSING = "PROCESSING";
  public static final String DONE = "DONE";
  public static final String DELETED = "DELETED";

  private final String text;
  private String status;

  public Task(String text) {
    this.text = text;
    this.status = PROCESSING;
  }

  public Task(String text, String status) {
    this.text = text;
    this.status = switch (status) {
      case "DONE" -> DONE;
      case "DELETED" -> DELETED;
      default -> PROCESSING;
    };
  }

  public String text() {
    return this.text;
  }

  public String status() {
    return this.status;
  }

  public void processing() {
    this.status = PROCESSING;
  }

  public void done() {
    this.status = DONE;
  }

  public void delete() {
    this.status = DELETED;
  }
}
