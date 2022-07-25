public class Task {
  private final String task;
  private boolean completed;

  public Task(String task) {
    this.task = task;
    this.completed = false;
  }

  public boolean completed() {
    return this.completed;
  }

  public String task() {
    return this.task;
  }

  public void toggle() {
    this.completed = !this.completed;
  }
}
