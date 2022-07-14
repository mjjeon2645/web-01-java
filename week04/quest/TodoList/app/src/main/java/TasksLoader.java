import models.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class TasksLoader {
  private final List<Task> tasks;

  public TasksLoader(List<Task> tasks) throws FileNotFoundException {
    this.tasks = tasks;

    File file = new File("tasks.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      Task task = parseTask(line);

      tasks.add(task);
    }
  }

  private Task parseTask(String text) {
    String[] words = text.split(",");

    return new Task(words[0]);
  }
}
