package models;

import java.util.ArrayList;
import java.util.List;

public class Tasks {
  private List<Task> tasks;

  public Tasks() {
    tasks = new ArrayList<>();
  }

  public void add(Task task) {
    tasks.add(task);
  }
}
