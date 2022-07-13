package repositories;

import models.Task;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskRepositoryTest {
  @Test
  void taskRepository() {
    TaskRepository taskRepository = new TaskRepository();

    taskRepository.addTask(new Task("밥 먹기"));

    List<Task> tasks = taskRepository.tasks();

    Task task = tasks.get(0);

    assertEquals(new Task("밥 먹기"), task);
  }
}
