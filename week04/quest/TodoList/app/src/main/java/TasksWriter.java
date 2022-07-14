import models.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TasksWriter {
  public TasksWriter(List<Task> tasks) throws IOException {
    FileWriter fileWriter = new FileWriter("output.csv");

    for(Task task : tasks){

      String line = task.toCsvRow();

      fileWriter.write(line + "\n");
    }
  }
}
