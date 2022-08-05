package utils;

import models.Task;
import org.junit.jupiter.api.Test;

import static models.Task.PROCESSING;
import static org.junit.jupiter.api.Assertions.*;

class TasksLoaderTest {
  @Test
  void parse() {
    TasksLoader tasksLoader = new TasksLoader();

    String line = "TIL 작성하기,PROCESSING";

    assertEquals(new Task("TIL 작성하기", "2021-03-06 17:24:57.107", PROCESSING),
        tasksLoader.parse(line));
  }
}
