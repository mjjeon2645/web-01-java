package repositories;

import models.Task;

import java.util.List;

public class TaskRepository {
  private List<Task> tasks;

  public TaskRepository(List<Task> tasks) {
    this.tasks = tasks;
  }

  public List<Task> getTasks() {
    return this.tasks;
  }

  public void addTask(Task task) {
    this.tasks.add(task);
  }
}
