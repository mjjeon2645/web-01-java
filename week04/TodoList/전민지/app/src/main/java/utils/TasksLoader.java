package utils;

import models.Task;
import models.Tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TasksLoader {
  public List<Task> loadTasks() throws FileNotFoundException {
    List<Task> tasks = new ArrayList<>();

    File file = new File("tasks.csv");

    Scanner scanner = new Scanner(file);

    while(scanner.hasNextLine()) {
      String line = scanner.nextLine();

      Task task = parseTask(line);

      tasks.add(task);
    }

    return tasks;
  }

  public void saveTasks(Tasks tasks) throws IOException {
    FileWriter fileWriter = new FileWriter("tasks.csv");

    for (Task task : tasks.tasks()) {
      String line = task.toCsvRow();
      fileWriter.write(line + "\n");
    }

    fileWriter.close();
  }

  public Task parseTask(String text) {
    String words[] = text.split(",");

    return new Task(words[0], words[1], Integer.parseInt(words[2]));
  }
}
