package utils;

import models.Task;
import repositories.TaskRepository;

import java.io.IOException;

public class FileWriter {
  public void writeFile(TaskRepository taskRepository) throws IOException {
    java.io.FileWriter fileWriter = new java.io.FileWriter("data.csv");

    for (Task task : taskRepository.getTasks()) {
      String line = task.text() + "," + task.status() + "\n";

      fileWriter.write(line);
    }

    fileWriter.close();
  }
}
