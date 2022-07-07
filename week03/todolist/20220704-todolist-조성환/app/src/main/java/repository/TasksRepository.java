package repository;


import java.util.ArrayList;
import java.util.List;

public class TasksRepository {
  private List<String> tasks = new ArrayList<>();

  public void addTask(String task) {
    tasks.add(task);
  }

  public List<String> getTask() {
    return new ArrayList<>(tasks);
  }

  public int tasksSize() {
    return tasks.size();
  }

  public void deleteTask(String task) {
    tasks.remove(task);
  }
}
