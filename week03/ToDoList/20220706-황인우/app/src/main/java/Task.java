public class Task {
  private final String task;
  private boolean completed;
  private boolean deleted;

  public Task(String task) {
    this.task = task;
    this.completed = false;
    this.deleted = false;
  }

  public boolean completed() {
    return this.completed;
  }

  public boolean deleted() {
    return this.deleted;
  }

  public String task() {
    return this.task;
  }

  public void toggle() {
    this.completed = !this.completed;
  }

  public void delete() {
    this.deleted = true;
  }
}
