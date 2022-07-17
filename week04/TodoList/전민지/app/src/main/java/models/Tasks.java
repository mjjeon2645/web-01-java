package models;

import utils.TasksLoader;

import java.io.IOException;
import java.util.List;

public class Tasks {
  private final List<Task> tasks;

  public Tasks() throws IOException {
    TasksLoader tasksLoader = new TasksLoader();
    tasks = tasksLoader.loadTasks();
  }

  public void add(Task task) {
    this.tasks.add(task);
  }

  public List<Task> tasks() {
    return tasks;
  }
}
