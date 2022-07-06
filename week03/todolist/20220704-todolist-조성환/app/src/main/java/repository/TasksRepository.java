package repository;

import java.util.ArrayList;
import java.util.List;

public class TasksRepository {
  private String task;
  private List<String> tasks = new ArrayList<>();

  public void send(String task) {
    this.task = task;
    tasks.add(task);
  }

  public String task() {
    return task;
  }
  public int tasks() {
    return tasks.size();
  }
}
