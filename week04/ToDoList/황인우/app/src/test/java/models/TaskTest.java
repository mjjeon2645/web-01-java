package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
  @Test
  void creation() {
    Task task1 = new Task("새로운 할 일 1-1");

    assertNotNull(task1);
    assertEquals("새로운 할 일 1-1", task1.text());
    assertEquals(Task.PROCESSING, task1.status());

    Task task2 = new Task("새로운 할 일 1-2", "PROCESSING");

    assertEquals("새로운 할 일 1-2", task2.text());
    assertEquals(Task.PROCESSING, task2.status());

    Task task3 = new Task("새로운 할 일 1-3", "DONE");

    assertEquals("새로운 할 일 1-3", task3.text());
    assertEquals(Task.DONE, task3.status());

    Task task4 = new Task("새로운 할 일 1-4", "DELETED");

    assertEquals("새로운 할 일 1-4", task4.text());
    assertEquals(Task.DELETED, task4.status());

    Task task5 = new Task("새로운 할 일 1-5", "ERROR");

    assertEquals("새로운 할 일 1-5", task5.text());
    assertEquals(Task.PROCESSING, task5.status());
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

    assertEquals(Task.DONE, task.status());
  }

  @Test
  void processing() {
    Task task = new Task("새로운 할 일 4");
    task.done();
    task.processing();

    assertEquals(Task.PROCESSING, task.status());
  }

  @Test
  void delete() {
    Task task = new Task("새로운 할 일 5");
    task.delete();

    assertEquals(Task.DELETED, task.status());
  }
}
