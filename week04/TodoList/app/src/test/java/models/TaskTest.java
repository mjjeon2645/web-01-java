import models.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTest {
  @Test
  void creation() {
    Task task = new Task("과제하기");

    assertEquals("과제하기", task.title());
  }

  @Test
  void TaskStateCompletion() {
    Task task = new Task("빨래하기");
    task.complete();

    assertEquals("COMPLETION", task.state());
  }

  @Test
  void TaskStateDeletion() {
    Task task = new Task("양치하기");
    task.delete();

    assertEquals("DELETION", task.state());
  }

  @Test
  void TaskStateProcessing() {
    Task task = new Task("공부하기");
    task.complete();
    task.processing();

    assertEquals("PROCESSING", task.state());
  }

  @Test
  void toCsvRow() {
    Task task = new Task("과제하기");

    task.delete();
    assertEquals("과제하기,DELETION", task.toCsvRow());
  }
}