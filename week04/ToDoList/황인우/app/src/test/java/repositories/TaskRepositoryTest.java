package repositories;

import models.Task;
import org.junit.jupiter.api.Test;

class TaskRepositoryTest {
  @Test
  void add() {
    TaskRepository taskRepository = new TaskRepository();

    taskRepository.addTask(new Task("작업 1"));


  }
}