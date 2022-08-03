package pages;

import models.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TasksPageGenerator extends PageGenerator {
  private final List<Task> tasks;

  public TasksPageGenerator(List<Task> tasks) {
    super();

    this.tasks = new ArrayList<>(tasks);
  }

  @Override
  public String showTasks() {
    return "<ul>\n" +
        tasks.stream()
        .map(task -> "<li>" + task.title() + "</li>\n")
        .collect(Collectors.joining()) +
        "</ul>\n";
  }
}
