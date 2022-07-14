package utils;

import models.Task;
import models.Tasks;

import java.io.FileWriter;
import java.io.IOException;

public class TaskWriter {

  public TaskWriter(Tasks tasks) throws IOException {
    FileWriter fileWriter = new FileWriter("tasks.csv");

    for (Task task : tasks.getTasks()) {
      String line = task.toCsvRow();
      fileWriter.write(line + "\n");
    }

    fileWriter.close();
  }
}
