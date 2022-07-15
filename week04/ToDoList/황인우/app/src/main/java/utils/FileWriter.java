package utils;

import models.Task;

import java.io.IOException;
import java.util.List;

public class FileWriter {
  public void saveTasks(List<Task> tasks) throws IOException {
    java.io.FileWriter fileWriter = new java.io.FileWriter("data.csv");

    for (Task task : tasks) {
      String line = task.text() + "," + task.status() + "\n";

      fileWriter.write(line);
    }

    fileWriter.close();
  }
}
