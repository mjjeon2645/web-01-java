import models.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskLoad {
  public List<Task> loadTask() throws FileNotFoundException {
    List<Task> tasks = new ArrayList<>();

    File file = new File("TaskList.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      Task task = parseTask(line);

      tasks.add(task);
    }

    return tasks;
  }

  private Task parseTask(String text) {
    String[] taskInformation = text.split(",");

    return new Task(taskInformation[0]);
  }
}
