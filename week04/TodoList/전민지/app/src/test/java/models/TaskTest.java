package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTest {
  @Test
  void creation() {
    Task task = new Task("빨래하기", "2022-07-13T03:04:16.972836", 1);
  }

  @Test
  void toCsvRow() {
    Task task = new Task("빨래하기", "2022-07-13T03:04:16.972836", 1);

    assertEquals("빨래하기,2022-07-13T03:04:16.972836,1", task.toCsvRow());
  }
}
