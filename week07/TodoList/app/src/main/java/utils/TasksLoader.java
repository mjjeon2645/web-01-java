package utils;

import models.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TasksLoader {
  public List<Task> load() throws FileNotFoundException {
    List<Task> tasks = new ArrayList<>();

    File file = new File("tasksdata.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      Task task = parse(line);

      tasks.add(task);
    }

    return tasks;
  }

  public Task parse(String line) {
    String[] words = line.split(",");

    return new Task(words[0], words[1], words[2]);
  }

  public void save(List<Task> tasks) throws IOException {
    FileWriter fileWriter = new FileWriter("tasksdata.csv");

    for (Task task : tasks) {
      String line = task.csvRow();

      fileWriter.write(line +"\n");
    }

    fileWriter.close();
  }
}
