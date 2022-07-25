import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
  private final List<Task> tasks;

  public TaskRepository() {
    tasks = new ArrayList<>();
  }

  public int taskRepositorySize() {
    return this.tasks.size();
  }

  public Task task(int index) {
    return this.tasks.get(index);
  }

  public void addNewTask(Task task) {
    this.tasks.add(task);
  }

  public void delete(int index) {
    this.tasks.remove(index);
  }
}
