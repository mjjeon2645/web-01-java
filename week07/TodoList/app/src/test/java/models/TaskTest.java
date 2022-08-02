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
}
