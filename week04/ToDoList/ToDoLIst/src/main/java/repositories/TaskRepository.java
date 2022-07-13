package repositories;

import models.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
  private List<Task> tasks;

  public TaskRepository() {
    this.tasks = new ArrayList<>();

  }

  public List<Task> tasks() {
    return tasks;
  }

  public void addTask(Task task) {
    tasks.add(task);
  }

  public void delete(Task taskTitle) {
    tasks.remove(taskTitle);
  }
}
