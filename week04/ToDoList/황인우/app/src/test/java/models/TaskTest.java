package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
  @Test
  void creation() {
    Task task = new Task("새로운 할 일 1");

    assertNotNull(task);
  }

  @Test
  void text() {
    Task task = new Task("새로운 할 일 2");

    assertEquals("새로운 할 일 2", task.text());
  }

  @Test
  void done() {
    Task task = new Task("새로운 할 일 3");
    task.done();

    assertEquals("DONE", task.status());
  }

  @Test
  void processing() {
    Task task = new Task("새로운 할 일 4");
    task.done();
    task.processing();

    assertEquals("PROCESSING", task.status());
  }

  @Test
  void delete() {
    Task task = new Task("새로운 할 일 5");
    task.delete();

    assertEquals("DELETED", task.status());
  }
}
