package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
  @Test
  void creation() {
    Task task = new Task("TIL 쓰기", "PROCESSING");

    assertEquals("TIL 쓰기", task.title());
    assertEquals("PROCESSING", task.state());
  }

  @Test
  void equals() {
    Task task1 = new Task("TIL 쓰기", "PROCESSING");
    Task task2 = new Task("TIL 쓰기", "PROCESSING");

    assertEquals(task1, task2);
  }

  @Test
  void csvRow() {
    Task task1 = new Task("TIL 쓰기", "PROCESSING");
    Task task2 = new Task("빨래 널기", "PROCESSING");

    String line1 = task1.csvRow();
    String line2 = task2.csvRow();


    assertEquals("TIL 쓰기,PROCESSING", line1);
    assertEquals("빨래 널기,PROCESSING", line2);
  }
}
