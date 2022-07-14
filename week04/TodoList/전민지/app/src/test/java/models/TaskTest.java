package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTest {
  @Test
  void creation() {
    Task task = new Task("빨래하기", "2022-07-13T03:04:16.972836", "ADDED");
  }

  @Test
  void equals() {
    Task task1 = new Task("빨래하기", "2022-07-13T03:04:16.972836", "ADDED");
    Task task2 = new Task("빨래하기", "2022-07-13T03:04:16.972836", "ADDED");

    assertEquals(task1, task2);
  }

  @Test
  void string() {
    Task task1 = new Task("빨래하기", "2022-07-13T03:04:16.972836", "ADDED");
    Task task2 = new Task("빨래하기", "2022-07-13T03:04:16.972836", "ADDED");

    assertEquals(task1.toString(), task2.toString());
  }

  @Test
  void toCsvRow() {
    Task task = new Task("빨래하기", "2022-07-13T03:04:16.972836", "ADDED");

    assertEquals("빨래하기,2022-07-13T03:04:16.972836,ADDED", task.toCsvRow());
  }
}
