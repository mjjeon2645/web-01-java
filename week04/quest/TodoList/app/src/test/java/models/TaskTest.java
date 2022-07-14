package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
  @Test
  void creation() {
    Task task = new Task("골든벨 공부하기",Task.PROGRESS);

    assertEquals("골든벨 공부하기" , task.task() );
  }
  @Test
  void completeStatus() {
    Task task = new Task("기합넣기", Task.PROGRESS);
    task.setComplete();

    assertEquals("COMPLETE" , task.state() );
  }
  @Test
  void deleteState() {
    Task task = new Task("기합넣기",Task.PROGRESS);
    task.setDelete();

    assertEquals("DELETE" , task.state() );
  }
  @Test
  void progressState() {
    Task task = new Task("기합넣기",Task.PROGRESS);
    task.setProgress();

    assertEquals("PROGRESS" , task.state() );
  }
  @Test
  void toCsvRow() {
    Task task = new Task("으헤!",Task.PROGRESS);
    task.setComplete();

    assertEquals("으헤!,COMPLETE", task.toCsvRow());
  }
}
