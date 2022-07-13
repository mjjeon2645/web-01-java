package repositories;

import models.Task;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskRepositoryTest {
  @Test
  void getTasks() {
    TaskRepository taskRepository = new TaskRepository(new ArrayList<>());

    assertEquals(0, taskRepository.getTasks().size());
  }

  @Test
  void addTask() {
    TaskRepository taskRepository = new TaskRepository(new ArrayList<>());

    taskRepository.addTask(new Task("나는 레드타입 휴먼 헌터 스페셜리스트 I.NU"));
    taskRepository.addTask(new Task("눈에 보이는 것들은 뭐든지 코.딩.한.다"));

    assertEquals(2, taskRepository.getTasks().size());
  }
}
