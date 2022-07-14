import models.Task;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoListTest {

  @Test
  void loadTasks() {
    TodoList todoList = new TodoList();
    List<Task> tasks = todoList.loadTasks();
    assertNotNull(tasks);
  }
}