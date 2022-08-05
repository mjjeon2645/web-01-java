package models;

import org.junit.jupiter.api.Test;

import static models.Task.PROCESSING;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
  @Test
  void creation() {
    Task task = new Task("TIL 쓰기", "2022-03-06 17:24:57.107", PROCESSING);

    assertEquals("TIL 쓰기", task.title());
    assertEquals("2022-03-06 17:24:57.107", task.timeStamp());
    assertEquals(PROCESSING, task.state());
  }

  @Test
  void csvRow() {
    Task task1 = new Task("TIL 쓰기", "2022-03-06 17:24:57.107", PROCESSING);
    Task task2 = new Task("빨래 널기", "2022-04-06 17:24:57.107", PROCESSING);

    String line1 = task1.csvRow();
    String line2 = task2.csvRow();


    assertEquals("TIL 쓰기,2022-03-06 17:24:57.107,PROCESSING", line1);
    assertEquals("빨래 널기,2022-04-06 17:24:57.107,PROCESSING", line2);
  }
}
