package repositories;

import models.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
  private List<Task> tasks;

  public TaskRepository() {
    tasks = new ArrayList<>();
  }

  public List<Task> getTasks() {
    return this.tasks;
  }

  public void addTask(Task task) {
    this.tasks.add(task);
  }
}
