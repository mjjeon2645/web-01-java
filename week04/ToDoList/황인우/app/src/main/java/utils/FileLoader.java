package utils;

import models.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileLoader {
  public List<Task> loadTasks() throws FileNotFoundException {
    File file = new File("data.csv");

    Scanner scanner = new Scanner(file);

    List<Task> lists = new ArrayList<>();

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      String[] components = line.split(",");

      String text = components[0];
      String status = components[1];

      if (status.equals(Task.PROCESSING)
          || status.equals(Task.DONE)
          || status.equals(Task.DELETED)) {
        Task task = new Task(text, status);

        lists.add(task);
      }
    }

    return lists;
  }

  public void saveTasks(List<Task> tasks) throws IOException {
    java.io.FileWriter fileWriter = new java.io.FileWriter("data.csv");

    for (Task task : tasks) {
      String line = task.text() + "," + task.status() + "\n";

      fileWriter.write(line);
    }

    fileWriter.close();
  }
}
