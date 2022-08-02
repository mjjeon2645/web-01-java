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
  public String html() {
    return "" +
        "<!DOCTYPE html>\n" +
        "<html lang=\"ko\">\n" +
        "<head>\n" +
        "<meta charset=\"UTF-8\">\n" +
        "<title>Todo List</title>\n" +
        "</head>\n" +
        "<body>\n" +
        "<h1>Todo List</h1>\n" +
        "<form method=\"POST\" enctype=\"text/plain\">\n" +
        "<p>\n" +
        "할 일: \n" +
        "<input type=\"text\" name=\"todo\" />\n" +
        "<button type=\"submit\">등록 </button>\n" +
        "</p>\n" +
        "</form>\n" +
        showTasks() +
        "</body>\n" +
        "</html>";
  }

  public String showTasks() {
    return "<ul>\n" +
        tasks.stream()
        .map(task -> "<li>" + task.title() + "</li>\n")
        .collect(Collectors.joining()) +
        "</ul>\n";
  }
}
