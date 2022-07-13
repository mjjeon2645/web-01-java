package utils;

import models.Task;

import java.io.FileWriter;
import java.io.IOException;

public class TaskWriter {
  public TaskWriter(Task task) throws IOException {
    FileWriter fileWriter = new FileWriter("taskRepository.csv");

//    String line = task.csvRow();

//    fileWriter.write(line);

    fileWriter.close();
  }
}
