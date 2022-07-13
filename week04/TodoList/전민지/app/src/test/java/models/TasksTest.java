package models;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
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

  @Test
  void loadTasks() throws FileNotFoundException {
    Tasks tasks = new Tasks();
    List<Task> taskLists = tasks.loadTasks();

    assertNotNull(taskLists);

    Task task1 = taskLists.get(0);
    Task task2 = taskLists.get(1);

    assertEquals(new Task("빨래하기", "2022-07-13T03:04:16.972836", "ADDED"),
        task1);
    assertEquals(new Task("책읽기", "2022-07-13T03:04:16.973256", "DELETED"),
        task2);

    assertEquals(3, taskLists.size());
  }
}
