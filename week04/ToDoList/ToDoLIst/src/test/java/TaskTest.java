import models.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTest {
  @Test
  void taskTitle() {
    Task task = new Task("과제하기");

    assertEquals("과제하기",task.title());
  }
}
