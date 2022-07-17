import models.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskLoader {
  public List<Task> loadTasks() throws FileNotFoundException {
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

  public void writeTask(List<Task> tasks) throws IOException {
    FileWriter fileWriter = new FileWriter("TaskList.csv");
    for (Task task : tasks) {
      String line = task.toCsvRow();

      fileWriter.write(line + "\n");
    }
    fileWriter.close();
  }

  private Task parseTask(String text) {
    String[] taskInformation = text.split(",");

    return new Task(taskInformation[0], taskInformation[1]);
  }
}
