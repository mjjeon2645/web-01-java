package models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TasksTest {
  @Test
  void creation() {
    Task task = new Task("2022-07-13T03:04:16.972836", "빨래하기", "ADDED");
    List<Task> tasks = new ArrayList<>();

    assertNotNull(tasks);

    tasks.add(task);

    assertEquals(tasks.get(0), task);
  }

  @Test
  void addTwoTask() {
    Task task1 = new Task("2022-07-13T03:04:16.972836", "빨래하기", "ADDED");
    Task task2 = new Task("2022-07-13T03:04:16.973256" ,"책읽기", "DELETED");
    List<Task> tasks = List.of(task1, task2);

    assertEquals(tasks, List.of(task1, task2));
  }

}