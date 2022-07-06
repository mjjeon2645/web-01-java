package repository;

public class TasksRepository {
  private String task;

  public void send(String task) {
    this.task = task;
  }

  public String getTask() {
    return task;
  }
}
