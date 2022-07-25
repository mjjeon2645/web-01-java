package models;

import org.junit.jupiter.api.Test;
import utils.TasksLoader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TasksTest {
  @Test
  void creation() {
    Task task = new Task("2022-07-13T03:04:16.972836", "빨래하기", 1);
    List<Task> tasks = new ArrayList<>();

    assertNotNull(tasks);

    tasks.add(task);

    assertEquals(tasks.get(0), task);
  }

  @Test
  void addTwoTask() {
    Task task1 = new Task("2022-07-13T03:04:16.972836", "빨래하기", 1);
    Task task2 = new Task("2022-07-13T03:04:16.973256" ,"책읽기", 0);
    List<Task> tasks = List.of(task1, task2);

    assertEquals(tasks, List.of(task1, task2));
  }

  @Test
  void loadTasks() throws FileNotFoundException {
    TasksLoader tasksLoader = new TasksLoader();
    List<Task> taskLists = tasksLoader.loadTasks();

    assertNotNull(taskLists);

    Task task1 = taskLists.get(0);
    Task task2 = taskLists.get(1);

    assertEquals(new Task("하나", "2022-07-15T20:45:15.973852", 1),
        task1);
    assertEquals(new Task("둘", "2022-07-15T20:45:19.278674", 1),
        task2);

    assertEquals(4, taskLists.size());
  }
}
