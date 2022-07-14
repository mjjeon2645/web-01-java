package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tasks {
  private final List<Task> tasks;

  public Tasks() throws FileNotFoundException {
    tasks = loadTasks();
  }

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

  public Task parseTask(String text) {
    String words[] = text.split(",");
    return new Task(words[0], words[1], words[2]);
  }

  public void add(Task task) {
    this.tasks.add(task);
  }

  public List<Task> getTasks() {
    return tasks;
  }
}
