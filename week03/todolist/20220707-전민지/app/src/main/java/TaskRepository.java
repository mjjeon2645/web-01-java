import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
  private List<String> tasks = new ArrayList<>();

  TaskRepository() {
    // TODO. 무얼 넣어야 할지, 뭘 해야할지 잘 모르겠음 -> 생성자에 대한 이해 부족쓰!!
  }

  public List<String> getTasks() {
    return tasks;
  }

  public int tasksSize() {
    return tasks.size();
  }

  public void addTask(String text) {
    tasks.add(text);
  }
}
