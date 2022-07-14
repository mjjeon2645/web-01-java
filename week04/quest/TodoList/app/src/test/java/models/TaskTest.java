package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
  @Test
  void creation() {
    Task task = new Task("골든벨 공부하기");

    assertEquals("골든벨 공부하기" , task.task() );
  }
  @Test
  void completeStatus() {
    Task task = new Task("기합넣기");
    task.setComplete();

    assertEquals("COMPLETE" , task.state() );
  }
  @Test
  void deleteState() {
    Task task = new Task("기합넣기");
    task.setDelete();

    assertEquals("DELETE" , task.state() );
  }
  @Test
  void progressState() {
    Task task = new Task("기합넣기");
    task.setProgress();

    assertEquals("PROGRESS" , task.state() );
  }
  @Test
  void toCsvRow() {
    Task task = new Task("으헤!");
    task.setProgress();

    assertEquals("으헤!,PROGRESS", task.toCsvRow());
  }
}
