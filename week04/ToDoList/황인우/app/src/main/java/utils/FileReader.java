package utils;

import models.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
  public List<Task> loadTasks() throws FileNotFoundException {
    File file = new File("data.csv");

    Scanner scanner = new Scanner(file);

    List<Task> lists = new ArrayList<>();

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      String[] components = line.split(",");

      String text = components[0];
      String status = components[1];

      Task task = new Task(text);

      switch (status) {
        case Task.PROCESSING -> task.processing();
        case Task.DONE -> task.done();
        case Task.DELETED -> task.delete();
      }

      lists.add(task);
    }

    return lists;
  }
}
